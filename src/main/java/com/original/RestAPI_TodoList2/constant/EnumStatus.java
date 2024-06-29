package com.original.RestAPI_TodoList2.constant;

public class EnumStatus {
	
	// statusのenum定義
	public enum Status {
		
		NOT_STARTED("未着手"),
		ON_GOING("進行中"),
		COMPLETED("完了");
		
		private String statusJapanese;
		
		private Status(String statusJapanese) {
			this.statusJapanese = statusJapanese;
		}
		
		public String getStatusJapanese() {
			return this.statusJapanese;
		}
	}
}
