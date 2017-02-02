# 2D_mine_field
A simple project that takes a 2D array with "mines" and returns a hint map that shows the location of the "mines".  The mines are represented by the astrid character.  Each square in the 2D hint field displays the number how many "mines" are adjacent to it.

2D array basics:
A basic 2D starts at point 0,0 with respect to x,y coordinates and as you move to the right the y coordinate increases, to the left decreases the y.  Moving up decreases the x value and moving down increases the x value.  While this completely differs from traditional mapping x and y as most learned in algebra it shouldn't be too difficult of a concept to grasp.

Example x,y coordinates in a 3x3 2D map:</br>
</br>[0,0] - [0,1] - [0,2]
</br>[1,0] - [1,1] - [1,2]
</br>[2,0] - [2,1] - [2,2]

To navigate though a 2D map to need to add or subtract the from x and y position.  Below is an example of this showing how one would navigate to the adjacent squares or positions on a 2D array:</br>

</br>[x-1][y-1] - [x-1][y] - [x-1][y+1]
</br>&nbsp;[x][y-1]  &nbsp;-  &nbsp;[x][y]&nbsp; - &nbsp;[x][y+1]
</br>[x+1][y-1] - [x+1][y] - [x+1][y+1]
<br> *sorry if it doesn't line up perfectly, hopefully that doesn't add confusion

In the example the home position x,y would relate to 1,1 and the adjacent positions would be how you would manipulate x and/or y to get to the desired position.
