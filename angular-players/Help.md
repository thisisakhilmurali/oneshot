Angular Project Usage Instructions

1. Click on the triangle play icon shown on the left side panel.
2. Scroll to the run bar.
3. You will find a dropdown in the top left side of the screen that says “Start&Debug”. -> You can click on this to start the application for previewing the project in browser and debugging.
4. The next entry is called “Test App” . You can use this to test your application when you have successfully completed the task set in the problem statement.
5. The next entry in the dropdown is called “Submit App”. You can select this entry and click on the play icon to submit your application code once you have completed all the tasks assigned.
   If the task is completed successfully an alphanumeric code will be displayed. This code needs to be pasted in the answer box provided in the platform,
   and the save answer button below it needs to be clicked to successfully complete evaluation.

Note: you need to click on the play icon selected in step 1 after selecting the required entry from dropdown mentioned in step 2 to experience the behaviour described above.

Note 2: Please ensure that instruction in step 5 is followed completely, otherwise your code may not be evaluated.

---
Project description:

You have decided to make an applicaion to simulate a mini cricket tournament called IPL. This application will let users make their own IPL teams. Users will be given a list of players, from which they can choose players for their own team. 

Additionally, if the user is not able to find a required player in the given list, he/she can add a new player and then add it to his team. The user can change the role of a already existing player (Batsman, Bowler, Wicket Keeper) based on his needs.
Moreover, the user can delete a player from the list. However updating and deletion of players in the list must be reflected in the teams made by that user.

Each team must have : 2 Batsman, 2 Bowler, 1 Wicket Keeper.

Your application must prompt the user below mentoned messages about their invalid team for respective scenarios.
1. 'You do not have required number of batsmen in your team'
2. 'You do not have required number of bowler in your team'
3. 'You do not have required number of wicketkeeper in your team'

You can look into src/app/player/player.model.ts for knowing the model of player used across the app.

You need to make changes in -
1. src/app/player/player.service.js
2. src/app/team/team.service.js

Note:
1. Do not change label, input, button vs. attributes since it will disrupt application behaviour(like id, \*ngFor, component name attributes).
2. Implementation related specifics are added directly as comments in the workspace.
3. Ensure that the structure and datatype of the components are followed as specified in the comments to ensure that the code is evaluated correctly.
4. Use Test App button often as described below (step 4), so you will be guided by test error messages.
5. When you delete or edit something you shouldn't have, test messages will give an error accordingly.
6. Click the "submit app" in the run dropdown once all the tasks are completed.Once all tasks are successfully implemented, you will receive an answer key.
7. Go back to the question and save the answer key in the text editor below.
