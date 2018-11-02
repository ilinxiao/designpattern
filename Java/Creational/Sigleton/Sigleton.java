public class Singleton {
 
	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
	private static Singleton instance = null;
 
	/* 私有构造方法，防止被实例化 */
	private Singleton() {
	}
 
	/* 静态工程方法，创建实例 */
	public static Singleton getInstance() {
		if (instance == null) {
			/* 该方法的缺陷在于赋值操作和实例化不是同步进行，而jvm的内部机制决定了没办法保证在多线程访问的情况下
			执行了赋值操作，就一定来得及实例化。所以可能会造成连续的实例赋值会得到空值情况。*/
			synchronized (instance){
				if (instance == null){
					instance = new Singleton();
				}
			}	
		}
		return instance;
	}
	
	public static synchronized syncInit(){
		if (instance == null){
			instance = new Singleton();
		}
	}
	
	/* 此种实现方式是仅仅在创建类的时候保持同步 */ 
	public static Singleton getInstance2(){
		if (instance == null){
			syncInit();
		}
		return instance;
	}
	
	private static class SingletonFactory{	
		private static Singleton instance = new Singleton();
	}
	
	/* 此种方式是使用一个内部类来维护单个实例。
	原因在于jvm能够保证一个类被加载的过程保持线程互斥,并且内部类只会被实例化一次。 */
	public static Singleton getInstance3(){
		return SingletonFactory.instance;
	}
 
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	public Object readResolve() {
		return instance;
	}
	
	/***
	注意事项：
	单例模式虽然看起来简单，但是在实现的时候尤其要考虑多线程访问的同步问题。
	synchronized关键字一定要恰当的使用，注意所锁的对象是不是全部的步骤都需要锁，仅在需要的步骤加锁能
	提升程序的性能。 
	***/
}