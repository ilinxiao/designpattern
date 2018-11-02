//视频接口
interface Video{
	public void getVideoContent();
}

class FLVVideo implements Video{
	public void getVideoContent(){
		System.out.println("FLV.");
	}
}

class MP4Video implements Video{
	public void getVideoContent(){
		System.out.println("MP4.");
	}
}

//图片接口定义
interface Image{
	//读取图片内容
	public void getImageContent();
}

class JPEGImage implements Image{
	public void getImageContent(){
		System.out.println("JPEG");
	}
}

class GIFImage implements Image{
	public void getImageContent(){
		System.out.println("GIF");
	}
}

//文本文档接口
interface Text{
	public void getTextContent();
}

class HTMLText implements Text{
	public void getTextContent(){
		System.out.println("HTML.");
	}
}

class XMLText implements Text{
	public void getTextContent(){
		System.out.println("XML.");
	}
}

//多媒体读取播放器(抽象工厂)
interface MultimediaPlayer{
	public Video getVideo();
	public Image getImage();
	public Text getText();
	
	// public void play();
}

//FLV、GIF、XML读取能力的多媒体播放器
class FlvGifXmlPlayer implements MultimediaPlayer{
	public Video getVideo(){
		Video vi = new FLVVideo();
		return vi;
	}
	
	public Image getImage(){
		Image img = new GIFImage();
		return img;
	}
	
	public Text getText(){
		Text text = new XMLText();
		return text;
	}
	
}

class Mp4JpegHtmlPlayer implements MultimediaPlayer{
	public Video getVideo(){
		Video vi = new MP4Video();
		return vi;
	}
	
	public Image getImage(){
		Image img = new JPEGImage();
		return img;
	}
	
	public Text getText(){
		Text text = new HTMLText();
		return text;
	}
}
	

class Test{
	public static void main(String args[]){
		MultimediaPlayer mr = new FlvGifXmlPlayer();
		Video vi = mr.getVideo();
		Image img = mr.getImage();
		Text text = mr.getText();
		
		vi.getVideoContent();
		img.getImageContent();
		text.getTextContent();
		
		System.out.println("NEW GENERATION:");
		MultimediaPlayer new_mr = new Mp4JpegHtmlPlayer();
		vi = new_mr.getVideo();
		img = new_mr.getImage();
		text = new_mr.getText();
		
		vi.getVideoContent();
		img.getImageContent();
		text.getTextContent();
	}
}


/*
你创建的神奇多媒体播放器®(FlvGifXmlPlayer)发布五年多了，已经被千千万万的用户使用着。瞧瞧~多么有成就感的事！是不是挺自豪？
是的，我也为你感到自豪^_^时光滚滚，网络世界再经过N年的技术浪潮迭代发展之后，已经从PC时代转到了移动互联网时代，你的千万用户
纷纷抱怨你的神奇多媒体播放器已经不能够在手机上随意使用了，很多格式已经无法播放。他们向你哭诉，请求你再次为他们开发一个播放利器！
作为一个那么关心用户体验感受的你，怎么能够置之不顾！于是，你又创建了另一个Mp4JpegHtmlPlayer。。。
*/