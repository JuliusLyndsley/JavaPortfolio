import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MineSweapPart extends JFrame
{
  private static final long serialVersionUID = 1L;
  private static final int WINDOW_HEIGHT = 760;
  private static final int WINDOW_WIDTH = 760;
  private static final int MINE_GRID_ROWS = 16;
  private static final int MINE_GRID_COLS = 16;
  private static final int TOTAL_MINES = 16;
  private static final int NO_MINES_IN_PERIMETER_GRID_VALUE = 0;
  private static final int ALL_MINES_IN_PERIMETER_GRID_VALUE = 8;
  private static final int IS_A_MINE_IN_GRID_VALUE = 9;
  private static int guessedMinesLeft = TOTAL_MINES;
  private static int actualMinesLeft = TOTAL_MINES;
  private static final String UNEXPOSED_FLAGGED_MINE_SYMBOL = "@";
  private static final String EXPOSED_MINE_SYMBOL = "M";
  private static final Color CELL_EXPOSED_BACKGROUND_COLOR = Color.lightGray;
  private static final Color CELL_EXPOSED_FOREGROUND_COLOR_MAP[] = 
{Color.lightGray, Color.blue, Color.green, Color.cyan, Color.yellow, Color.orange, Color.pink, Color.magenta, Color.red, Color.red};
  private boolean running = true;
  private int[][] mineGrid = new int[MINE_GRID_ROWS][MINE_GRID_COLS];
  private static final int NMINES = (MINE_GRID_ROWS*MINE_GRID_COLS) - TOTAL_MINES;
  private static int nCount = 0;
  public MineSweapPart()
  {
    this.setTitle("MineSweap" + MineSweapPart.guessedMinesLeft +" Mines left");
    this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    this.setResizable(false);
    this.setLayout(new GridLayout(MINE_GRID_ROWS, MINE_GRID_COLS, 0, 0));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.createContents();
    this.setMines();
    this.setVisible(true);
  }
  public void createContents()
  {
    for (int gr = 0; gr < MINE_GRID_ROWS; ++gr)
    {  
      for (int gc = 0; gc < MINE_GRID_COLS; ++gc)
      {  
        this.mineGrid[gr][gc] = 0; 
        MyJButton but = new MyJButton("", gr, gc); 
        but.addActionListener(new MyListener());
        this.add(but);
      }  
    }
  }
  private void setMines()
  {
	  for (int i = 0; i < TOTAL_MINES; ++i)
		{
			int rows = (int)(Math.random() * MINE_GRID_ROWS);  
			int columns = (int)(Math.random() * MINE_GRID_COLS);  
			
			if(this.mineGrid[rows][columns] < IS_A_MINE_IN_GRID_VALUE) {
				this.mineGrid[rows][columns] = IS_A_MINE_IN_GRID_VALUE;
				
				for (int temp1 = -1; temp1 <=1; ++temp1)
				{
					for (int temp2 = -1; temp2 <=1; ++temp2) {
						if ( (!( (temp1 == 0) && (temp2==0) )) && (temp1+columns >= 0) && (temp1+columns <= (MINE_GRID_COLS - 1)) && (temp2+rows >= 0) && (temp2+rows <= (MINE_GRID_ROWS - 1)))
							if(this.mineGrid[temp2+rows][temp1+columns] != 9)
								++this.mineGrid[temp2+rows][temp1+columns];
					}
				}
			}
			else --i;
		}
  }
  
  private String getGridValueStr(int row, int col)
  {
    if ( this.mineGrid[row][col] == NO_MINES_IN_PERIMETER_GRID_VALUE )
      return "";
    else if ( this.mineGrid[row][col] > NO_MINES_IN_PERIMETER_GRID_VALUE && 
              this.mineGrid[row][col] <= ALL_MINES_IN_PERIMETER_GRID_VALUE )
      return "" + this.mineGrid[row][col];
    else
      return MineSweapPart.EXPOSED_MINE_SYMBOL;
  }
  private class MyListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      if ( running )
      {
        int mod = event.getModifiers();
        MyJButton mjb = (MyJButton)event.getSource();
        boolean flagged = 
mjb.getText().equals(MineSweapPart.UNEXPOSED_FLAGGED_MINE_SYMBOL);
        boolean exposed = 
mjb.getBackground().equals(CELL_EXPOSED_BACKGROUND_COLOR);
        if ( !flagged && !exposed && (mod & ActionEvent.CTRL_MASK) != 0 )
        {
          mjb.setText(MineSweapPart.UNEXPOSED_FLAGGED_MINE_SYMBOL);
          --MineSweapPart.guessedMinesLeft;
          if ( mineGrid[mjb.ROW][mjb.COL] == IS_A_MINE_IN_GRID_VALUE )
          {
        	  --MineSweapPart.actualMinesLeft;
          }
          setTitle("MineSweap" +  MineSweapPart.guessedMinesLeft +" Mines left");
        }
        else if ( flagged && !exposed && (mod & ActionEvent.ALT_MASK) != 0 )
        {
          mjb.setText("");
          ++MineSweapPart.guessedMinesLeft;
          if ( mineGrid[mjb.ROW][mjb.COL] == IS_A_MINE_IN_GRID_VALUE )
          {
        	  ++MineSweapPart.actualMinesLeft;
          }
          setTitle("MineSweap" +MineSweapPart.guessedMinesLeft +" Mines left");
        }
        else if ( !flagged && !exposed )
        {
          exposeCell(mjb);
        }  
        
        if (MineSweapPart.actualMinesLeft == 0 && MineSweapPart.guessedMinesLeft == 0 && nCount== NMINES)
        {
        	setTitle("You have won!");
        	running = false;
        }
      }
    }
    
    public void exposeCell(MyJButton mjb)
    {
      if ( !running )
        return;
      mjb.setBackground(CELL_EXPOSED_BACKGROUND_COLOR);
      mjb.setForeground(CELL_EXPOSED_FOREGROUND_COLOR_MAP[mineGrid[mjb.ROW]
[mjb.COL]]);
      mjb.setText(getGridValueStr(mjb.ROW, mjb.COL));
      if ( mineGrid[mjb.ROW][mjb.COL] == IS_A_MINE_IN_GRID_VALUE )
      {  
    	  for (int temp1 = 0; temp1 < MINE_GRID_ROWS; ++temp1) {
    		  for (int temp2 = 0; temp2 < MINE_GRID_COLS; ++temp2)
    		  {
    			  MyJButton jbn = (MyJButton)mjb.getParent().getComponent(getWin(temp2, temp1));
    			  if (mineGrid[temp2][temp1] >= 9)
    			  {
    				  if(!(jbn.getText().equals(UNEXPOSED_FLAGGED_MINE_SYMBOL)))
    					  jbn.setText(EXPOSED_MINE_SYMBOL);
    				  else if (jbn.getText().equals(UNEXPOSED_FLAGGED_MINE_SYMBOL))
    					  jbn.setText(UNEXPOSED_FLAGGED_MINE_SYMBOL);
    			  }
    			  else if (!(mineGrid[temp2][temp1]>=9)&&jbn.getText().equals(UNEXPOSED_FLAGGED_MINE_SYMBOL)){
    				  jbn.setForeground(CELL_EXPOSED_FOREGROUND_COLOR_MAP[9]);
						jbn.setText("X");
    			  }
    		  }
    	  }
    	setTitle("You lost!");
    	running = false;
        return;
      }
      if ( mineGrid[mjb.ROW][mjb.COL] == NO_MINES_IN_PERIMETER_GRID_VALUE )
      {
    	  for (int temp1 = -1; temp1 <= 1; ++temp1){
				for (int temp2 = -1; temp2 <= 1; ++temp2){
					if ( (!( (temp1 == 0) && (temp2==0) )) && (temp1+mjb.COL >= 0) && (temp1+mjb.COL <= (MINE_GRID_COLS - 1)) && (temp2+mjb.ROW >= 0) && (temp2+mjb.ROW <= (MINE_GRID_ROWS - 1)) ){
						MyJButton jbn = (MyJButton)mjb.getParent().getComponent(getWin(mjb.ROW+temp2,mjb.COL+temp1));
						if (!jbn.getText().equals(UNEXPOSED_FLAGGED_MINE_SYMBOL) && !jbn.getBackground().equals(CELL_EXPOSED_BACKGROUND_COLOR)){
							jbn.setForeground(CELL_EXPOSED_BACKGROUND_COLOR);
							exposeCell(jbn);
						}
					}
				}
			}	
			
			return;
      }
    }
  }
  
  public int getWin(int row, int column) {
	  return (row * MINE_GRID_ROWS) + column;
  }
  public static void main(String[] args)
  {
    new MineSweapPart();
  }
}