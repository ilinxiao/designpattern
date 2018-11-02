//图片接口定义
interface Image{
	//读取图片内容
	public void getContent();
}

class JPEGImage implements Image{
	public void getContent(){
		System.out.println("JPEG");
	}
}

class GIFImage implements Image{
	public void getContent(){
		System.out.println("GIF");
	}
}

//图片创建抽象工厂
interface ImageFactory{
	//构建JPEG图像
	public Image createImage();
}

class JPEGImageFactory implements ImageFactory{
	public Image createImage(){
		Image img = new JPEGImage();
		return img;
	}
}

class GIFImageFactory implements ImageFactory{
	public Image createImage(){
		Image img = new GIFImage();
		return img;
	}
}

class Test{
	public static void main(String args[]){
		ImageFactory imageFactory;
		Image image;
		imageFactory = new JPEGImageFactory();
		image = imageFactory.createImage();
		image.getContent();
	}
}