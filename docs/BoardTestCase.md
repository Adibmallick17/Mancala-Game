* Test Case Document for Board Class:

1. captureStones(int stoppingPoint)

Test Case ID	Description	                             Input	Expected Output
T1	            Stopping point within valid range	       4	    0
T2	            Stopping point outside valid range	       10	    0
T3	            Stopping point with one stone in the pit   2	    0


2. distributeStones(int startingPoint)

Test Case ID	Description	                            Input	Expected Output Range
T1	            Starting point within valid range	        5	Last pit in [0, 11]
T2	            Starting point outside valid range	        12	-1
T3	            Starting point with empty pit	            3	-1


3. getNumStones(int pitNum)

Test Case ID	Description	                            Input	Expected Output
T1	            Pit number within valid range	            5	4
T2	            Pit number outside valid range	           13	Throws exception
T3	            Pit number for an empty pit	                2	0


4. isSideEmpty(int pitNum)

Test Case ID	Description	                        Input	Expected Output
T1	            Pit number within valid range	        8	false
T2	            Pit number outside valid range	        13	Throws exception
T3	            Pit number for an empty side	        1	true


5. resetBoard()

Test Case ID	Description	                            Input / State	    Expected Output / State
T1	            Reset board when stones distributed	        Initialized	    Board reset
T2	            Reset board with an empty board	Empty	     Board          reset


6. registerPlayers(Player one, Player two)

Test Case ID	Description	                                 Input	         Expected Output / State
T1	            Register players with valid parameters	    Alice, Bob	     Players registered
T2	            Register players with null parameters	    null, null	     No change
T3	            Register players with same player object	Alice, Alice	 No change

