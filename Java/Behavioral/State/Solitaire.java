//纸牌游戏
class Solitaire{
	
	//设置等级
	public void setLevel(PlayerLevel level){
		this.level = level;
	}
}

//玩家等级
abstract PlayerLevel{
	public void play(Solitaire game);
}

class Primary extends PlayerLevel{
	public void play(Solitaire game){
		System.out.println("Play...");
	}
}

