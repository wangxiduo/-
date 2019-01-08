package Syndemo1;

/*
 * 
 * 单例模式确保一个雷只有一个对象
 */
public class SynDemo1 {
	public static void main(String[] args) {
		/*
		 * Jvm jvm1 = Jvm.getInstance(100); Jvm jvm2 = Jvm.getInstance(220);
		 */
		JvmTread thread1 = new JvmTread(100);
		JvmTread thread2 = new JvmTread(500);
		thread1.start();
		thread2.start();
		System.out.println(thread1);
		System.out.println(thread2);

	}

}

class JvmTread extends Thread {
	private long time;

	public JvmTread() {

	}

	public JvmTread(long time) {
		this.time = time;
	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + "---->创建:" + Jvm.getInstance(time));
	}
}

/*
 * 单例模式懒汉式，双重检查 1、构造器私有化，避免外部直接创建对象 2、申明一个私有的静态变量 3、创建一个对外的公共的静态方法访问该变量，如果没有对象，创建对象
 */
class Jvm {
	// 2、申明一个私有的静态变量
	private static Jvm instance = null;

	// 1、构造器私有化，避免外部直接创建对象
	private Jvm() {

	}

	// 3、创建一个对外的公共的静态方法访问该变量，如果没有对象，创建对象
	public static synchronized Jvm getInstance2(long time) {
		if (instance == null) {
			try {
				// 延时，放大错误发生的概率
				Thread.sleep(time);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			instance = new Jvm();
		}

		return instance;
	}

	public static Jvm getInstance1(long time) {
		if (instance == null) {
			try {
				// 延时，放大错误发生的概率
				Thread.sleep(time);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			instance = new Jvm();
		}

		return instance;
	}

	public static Jvm getInstance3(long time) {
		// a,b需要等待，延时效率不高
		synchronized (Jvm.class) {
			if (instance == null) {
				try {
					// 延时，放大错误发生的概率
					Thread.sleep(time);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				instance = new Jvm();
			}

			return instance;
		}
	}

	public static Jvm getInstance(long time) {
		// 提高已经存在对象的访问效率
		if (instance == null) {
			synchronized (Jvm.class) {
				if (instance == null) {
					try {
						// 延时，放大错误发生的概率
						Thread.sleep(time);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					instance = new Jvm();
				}

				return instance;
			}
		}
		return instance;
	}
}
