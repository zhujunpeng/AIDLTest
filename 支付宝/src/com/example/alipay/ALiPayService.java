package com.example.alipay;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class ALiPayService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new SafePay();
	}
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("支付宝服务被创建");
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("支付宝服务被销毁");
	}
	public boolean pay(long time,String pwd,double money){
		if ("123".equals(pwd)) {
			return true;
		}else{
			return false;
		}
	}
	
	private class SafePay extends ISafePay.Stub{

		@Override
		public boolean callpay(long time, String pwd, double money)
				throws RemoteException {
			
			return pay(time, pwd, money);
		}
		
	}

}
