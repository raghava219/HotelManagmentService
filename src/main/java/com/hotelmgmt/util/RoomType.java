package com.hotelmgmt.util;

/**
 * This is the Enum class for RoomType constants.
 * @author ragha
 *
 */
public enum RoomType {
	
	QUEEN_BED("Queen Bed") {
		public String toString() {
			return "Q";
		}
	},
	
	KING_BED("King Bed") {
		public String toString() {
			return "K";
		}
	};  
	
	private String info;
	
	RoomType(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
}
