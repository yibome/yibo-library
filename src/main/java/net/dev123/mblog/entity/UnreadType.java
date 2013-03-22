package net.dev123.mblog.entity;

public enum UnreadType {
	COMMENT(1),
	METION(2),
	DIRECT_MESSAGE(3),
	FOLLOWER(4);

	private int type;

	private UnreadType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
