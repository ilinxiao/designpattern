import java.util.List;
import java.util.ArrayList;

//纸牌游戏
class Solitaire{
	
	private BasePlayer playerLevel;
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
	public void setLevel(BasePlayer player){
		this.player = player;
	}
	
	//玩游戏
	public void play(int time){
		for(int i=0; i<time; i++){
			this.playerLevel.play();
			System.out.println("您的积分为："+ this.getScore());
			System.out.println("现在您的玩家等级为:"+ this.playerLevel.getClass().getName());
		}
	}
	
	public int getScore(){
		return this.score;
	}
	public void setScore(int score){
		this.score = score;
	}
}

//玩家等级
interface PlayerDecorator{
	public void play();
}

class BasePlayerDecorator implements PlayerDecorator{
	private PlayerDecorator playerDecorator;
	
	public BasePlayerDecorator(PlayerDecorator pd){
		this.playerDecorator = pd;
	}
	
	public void play(){
		System.out.println("CAN'T PLAY");
	}
}

class PrimaryDecorator extends BasePlayerDecorator{
	
	public PrimaryDecorator(PlayerDecorator pd){
		super(pd);
	}
	
	/**
	游戏规则：
	随机产生0或1，为0代表输，输赢扣除/增加5积分
	**/
	public void play(Solitaire so){
		if(so.getScore() > 0){
			System.out.println("游戏开始....");
			// sleep(500);
			int result = (int)(Math.random()*2);
			if(result == 0){
				System.out.println("OOPS!很遗憾你没能够打败对手，请再接再厉！");
				so.setScore(so.getScore()-5);
			}else{
				System.out.println("恭喜你！你赢得了这场对决！");
				so.setScore(so.getScore()+5);
			}
		}
	}
}

class SecondaryDecorator extends PrimaryDecorator{
	
	public SecondaryDecorator(PlayerDecorator pd){
		super(pd);
	}
	
	public void play(){
		super.play();
		this.doubleScore();
	}
	
	public void doubleScore(){
		System.out.println("DOUBLE SCORE");
	}
}

class ProfessionalDecorator extends SecondaryDecorator{
	
	public ProfessionalDecorator(PlayerDecorator pd){
		super(pd);
	}
	
	public void play(){
		super.play();
		this.changeCards();
	}
	
	public void changeCards(){
		System.out.println("CHANGE CARDS");
	}
}

class FinalDecorator extends ProfessionalDecorator{
	
	public FinalDecorator(PlayerDecorator pd){
		super(pd);
	}
	
	public void play(){
		super.play();
		this.peekCards();
	}
	
	public void peekCards(){
		System.out.println("PEEK CARDS");
	}
}

abstract class BasePlayer implements PlayerDecorator{
	protected Solitaire so;
	public abstract void changeLevel();
	public abstract void play();	
}

class Primary extends BasePlayer{
	
	private BasePlayer playerLevel;
	
	public Primary(){
		
	}
	
	public Primary(Solitaire so){
		this.so = so;
		this.specialPropList.add("Play");
	}
	
	public Primary(BasePlayer playerLevel){
		this.so = this.playerLevel.so;
	}
	
	
	public void specialProps(){
		System.out.print("Play");
	}
	
	/**
	等级升级规则：
	0~15：Primary
	15~25: Secondary
	25~35: Professional
	35~50: Final
	**/
	public void changeLevel(){
		int score = so.getScore();
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

class Secondary extends Primary{
	public Secondary(){}
	
	public Secondary(Solitaire so){
		this.so = so;
	}
	
	public Secondary(PlayerLevel pl){
		super(pl);
	}
	
	public void play(){
		super.play();
	}
	
	public void changeLevel(){
		int score = so.getScore();
		
		if(score < 0){
			System.out.println("您的积分不足，无法开始游戏。");
		}else if(score >=0 && score <=15){
			so.setLevel(new Primary(this));
		}else if(score > 25 && score <= 35){
			so.setLevel(new Professional(this));
		}else if(score > 35){
			so.setLevel(new Final(this));
		}
	}
}

class Professional extends Secondary{
	public Professional(){}
	
	public Professional(Solitaire so){
		this.so = so;
	}
	
	public Professional(PlayerLevel pl){
		super(pl);
	}
	
	public void play(){
		super.play();
		this.specialProps();
	}
	
	public void specialProps(){
		System.out.println("CHANGE CARDS");
	}
	
	public void changeLevel(){
		int score = so.getScore();
		
		if(score < 0){
			System.out.println("您的积分不足，无法开始游戏。");
		}else if(score >=0 && score <= 15){
			so.setLevel(new Primary(this));
		}else if(score > 15 && score <= 25){
			so.setLevel(new Secondary(this));
		}else if(score > 35){
			so.setLevel(new Final(this));
		}
	}
}

class Final extends Professional{
	public Final(){}
	
	public Final(Solitaire so){
		this.so = so;
	}
	
	public Final(PlayerLevel pl){
		super(pl);
	}
	
	public void play(){
		super.play();
		this.specialProps();
	}
	
	public void specialProps(){
		System.out.println("PEEK CARDS");
	}
	
	public void changeLevel(){
		int score = so.getScore();
		
		if(score < 0){
			System.out.println("您的积分不足，无法开始游戏。");
		}else if(score >=0 && score <= 15){
			so.setLevel(new Primary(this));
		}else if(score >15 && score <=25){
			so.setLevel(new Secondary(this));
		}else if(score > 25 && score <= 35){
			so.setLevel(new Professional(this));
		}
	}
}

class SolitaireClient{
	public static void main(String args[]){
		Solitaire so = new Solitaire("Linxiao", 10);
		so.play(10);
	}
}
