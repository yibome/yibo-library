package net.dev123.sns.entity;

public class EventInvitee {
	private String id;

	private String name;

	private RsvpStatus rsvpStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RsvpStatus getRsvpStatus() {
		return rsvpStatus;
	}

	public void setRsvpStatus(RsvpStatus rsvpStatus) {
		this.rsvpStatus = rsvpStatus;
	}

}
