//纸牌游戏
class Solitaire{
	
	private PlayerLevel playerLevel;
	private int score;
	private String playerName;
	
	public Solitaire(String playerName, int baseScore){
		this.playerName = playerName;
		this.score = baseScore;
		this.playerLevel = new Primary(this);
		
		System.out.println("亲爱的玩家，"+ this.playerName + " 欢迎您！ ");
		System.out.println("游戏即将开始，请耐心等待...");
	}
	
	//设置等级
	public void setLevel(PlayerLevel level){
		this.palyerLevel = level;
	}
	
	//玩游戏
	public void play(int time){
		
	}
	
	public int getScore(){
		return this.score;
	}
	public void setScore(int score){
		this.score = score;
	}
}

//玩家等级
abstract PlayerLevel{
	protected Solitaire so;
	public void specialProps();
	protected List specialPropList;
	/**
	等级升级规则：
	0~15：Primary
	15~25: Secondary
	25~35: Professional
	35~50: Final
	**/
	public void changeLevel();
	public void play(){
		System.out.println("游戏开始....");
		sleep(500);
		int result = (int)(Math.random()*2);
		if(result == 0){
			System.out.println("OOPS!很遗憾你没能够打败对手，请再接再厉！")
			so.setScore(so.getScore()-5);
		else{
			System.out.println("恭喜你！你赢得了这场对决！");
			so.setScore(so.getScore()+5);
		}
	}
}

class Primary extends PlayerLevel{
	public Primary(Solitaire so){
		this.so = so;
	}
	
	public Primary(PlayerLevel pl){
		this.so = pl.so;
	}
	
	public void play(){
		super.play()
		this.specialProps();
	}
	
	public void specialProps(){
		super.specialProps();
		System.out.print("Play");
	}
	
	public void changeLevel(){
		score = so.getScore();
		if(score < 0){
			System.out.println("您的积分不足，无法开始游戏。");
		}else if(score >15 && score <=25){
			so.setLevel(new Secondary(this));
		}else if(score > 25 && score <= 35){
			so.setLevel(new Professional(this));
		}else if(score > 35){
			so.setLevel(new Final(this));
		}
	}
}

class  extends PlayerLevel{
	public (Solitaire so){
		this.so = so;
	}
	
	public (PlayerLevel pl){
		this.so = pl.so;
	}
	
	public void play(){
		super.play()
		this.specialProps();
	}
	
	public void specialProps(){
		System.out.println("");
	}
	
	public void changeLevel(){
		score = so.getScore();
	
	}
}

class  extends PlayerLevel{
	public (Solitaire so){
		this.so = so;
	}
	
	public (PlayerLevel pl){
		this.so = pl.so;
	}
	
	public void play(){
		super.play()
		this.specialProps();
	}
	
	public void specialProps(){
		System.out.println("");
	}
	
	public void changeLevel(){
		score = so.getScore();
	
	}
}

class Final extends PlayerLevel{
	public Final(Solitaire so){
		this.so = so;
	}
	
	public Final(PlayerLevel pl){
		this.so = pl.so;
	}
	
	public void play(){
		super.play()
		this.specialProps();
	}
	
	public void specialProps(){
		System.out.println("");
	}
	
	public void changeLevel(){
		score = so.getScore();
	
	}
}
