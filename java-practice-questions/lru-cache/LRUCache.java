
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K, V> {

    private final ConcurrentLinkedQueue<K> concurrentLinkedQueue = new ConcurrentLinkedQueue<K>();

    private final ConcurrentHashMap<K, V> concurrentHashMap = new ConcurrentHashMap<K, V>();

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    int maxSize = 0;

    public LRUCache(final int MAX_SIZE) {
        this.maxSize = MAX_SIZE;
    }

    public V get(K key) {


        readWriteLock.readLock().lock();
        try {
            V v = concurrentHashMap.get(key);
            if (v != null) {
                concurrentLinkedQueue.remove(key);
                concurrentLinkedQueue.add(key);
            }

            //@todo return the appropriate object
            return v;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public int size() {
        readWriteLock.readLock().lock();

        try {
            return concurrentHashMap.size();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }


    public void put(K key, V value) {

        readWriteLock.writeLock().lock();
        try {
            if (concurrentHashMap.containsKey(key)) {
                concurrentLinkedQueue.remove(key);
            } else if (concurrentLinkedQueue.size() >= maxSize) {
                K IruKey = concurrentLinkedQueue.poll();
                assert IruKey != null;
                concurrentHashMap.remove(IruKey);
            }
            concurrentLinkedQueue.add(key);
            concurrentHashMap.put(key, value);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}