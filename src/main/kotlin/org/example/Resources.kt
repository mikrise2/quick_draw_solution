package org.example

object Resources {
    const val MENU = """

	  Quick Draw

	  Face your opponent and wait for the signal. Once the
	  signal is given, shoot your opponent by pressing [space]
	  before they shoot you. It's all about your reaction time.

	  Choose Your Opponent:
	  [1] Easy....1000 milliseconds
	  [2] Medium...500 milliseconds
	  [3] Hard.....250 milliseconds
	  [4] Harder...125 milliseconds
	  [escape] give up
	"""

    const val WAIT = """

	  Quick Draw
	                                                        
	                                                        
	                                                        
	              _O                          O_            
	             |/|_          wait          _|\|           
	             /\                            /\           
	            /  |                          |  \          
	  ------------------------------------------------------
	"""

    const val FIRE = """

	  Quick Draw
	                                                        
	                         ********                       
	                         * FIRE *                       
	              _O         ********         O_            
	             |/|_                        _|\|           
	             /\          spacebar          /\           
	            /  |                          |  \          
	  ------------------------------------------------------
	"""

    const val LOSE_TOO_SLOW = """

	  Quick Draw
	                                                        
	                                                        
	                                                        
	                                        > ╗__O          
	           //            Too Slow           / \         
	          O/__/\         You Lose          /\           
	               \                          |  \          
	  ------------------------------------------------------
       Play Again [enter] or quit [escape]? 
	"""

    const val LOSE_TOO_FAST = """

	  Quick Draw
	                                                        
	                                                        
	                                                        
	                         Too Fast       > ╗__O          
	           //           You Missed          / \         
	          O/__/\         You Lose          /\           
	               \                          |  \          
	  ------------------------------------------------------
       Play Again [enter] or quit [escape]? 
	"""

    const val WIN = """

	  Quick Draw
	                                                        
	                                                        
	                                                        
	            O__╔ <                                      
	           / \                               \\         
	             /\          You Win          /\__\O        
	            /  |                          /             
	  ------------------------------------------------------
       Play Again [enter] or quit [escape]? 
	"""

    const val SPACE_CODE = 32
    const val ESC_CODE = 27
    const val ENTER_CODE = 13
    const val CODE_1 = 49
    const val CODE_2 = 50
    const val CODE_3 = 51
    const val CODE_4 = 52

    const val WAIT_MIN: Long = 3000
    const val WAIT_MAX: Long = 7000
}
