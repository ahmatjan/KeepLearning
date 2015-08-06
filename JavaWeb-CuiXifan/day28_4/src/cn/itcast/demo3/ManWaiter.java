package cn.itcast.demo3;

public class ManWaiter implements Waiter {

	@Override
	public void serve() {
		System.out.println("服务中。。。");
	}

	@Override
	public void charge() {
		System.out.println("混蛋，给我钱！！");
	}

}
