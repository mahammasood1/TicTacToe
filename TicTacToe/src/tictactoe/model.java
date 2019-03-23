
package tictactoe;

public class model {
    
    private int[][] board;
    
    model()
    {
        board = new int[3][3];
        
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                board[i][j] = -1;
            }
        }
    }
    
  
    public boolean checkWin(int turn, int row, int col, GUI view)
    {

        if(turn%2 == 0)
            board[row][col] = 1;
        
        else
            board[row][col] = 0;
 
        //checking horizontal win
        for(int i = 0; i<3; i++)
        {
         if(board[i][0] != -1 && board[i][0] == board[i][1] && board[i][0] == board[i][2])
         {
             view.updateScore(turn);            //updates scoreboard respective to win
             view.reset();                      //resets board for next match
             GameOver();                       //reset database matrix 
             
             return true;
         }   
         
         
        }
        
        //checking vertical win
        for(int i = 0; i<3; i++)
        {
         if(board[0][i]!=-1 && board[0][i] == board[1][i] && board[0][i] == board[2][i])
         {
             view.updateScore(turn);
             view.reset();
             GameOver();
             
             return true;
         }
         
        }
        
       
        //checking diagonal win
         if(board[0][0]!=-1 && board[0][0] == board[1][1] && board[0][0] == board[2][2])
         {
             view.updateScore(turn);
             view.reset();
             GameOver();
             
             return true;
         }
         
         if(board[2][0]!=-1 && board[2][0] == board[1][1] && board[2][0] == board[0][2])
         {
             view.updateScore(turn);
             view.reset();
             GameOver();
             
             return true;
         }
        
         //no winning match found
         return false;
        
    }

    public boolean checkDraw()
   {
       int count = 0;
       
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(board[i][j] == -1)        //finding if any index is unmarked
                    count++;
            }
        }
       
        if(count>0)
            return false;
        
        else
            return true;
        
   }

    
   void GameOver()
   {
       //clearing the matrix for new round
       
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                board[i][j] = -1;
            }
        }
       
   }
    
}
