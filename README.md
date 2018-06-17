# 4u-cpt-kobras
An awesome school simulator

CPT UML CAN BE FOUND HERE
https://drive.google.com/file/d/1XImkd3lKZEuy_Xqwi0SWBkSPfnRyidDI/view?usp=sharing





THINGS TO KNOW

quests.txt
whichOrder roomid DialogueID


decisions.txt // look under decision to find out number for the effects
id
String choice 1
String choice 2
dialogueIDfor1 dialogueIDfor2 effectfor1 effectfor2 puzzle id


other note speakers are made of name text and imgObj and can be repeated
Dialogue text format **decision spot can be left blank, no ;;
id
imgObj
decision;;
name
text here
imgObj of speaker
---------------------------------------
id
imgObj

name
text here
imgObj
-------------------------
puzzle id format (roomNum) * 100 + grade - 9

locations.txt format: id roomNorth roomEast roomSouth roomWest bgimgID dialogue1 d2 d3 d4 d5 d6 d7 d8

imgList.txt format: id xpos ypos width height imgName

sm.setState is called to change states only in the state classes

State is basically a controller

statically call on the mouse class to check different mouse inputs

statically call Content to retrieve data from the models
ex Content.decisions.get(int id)