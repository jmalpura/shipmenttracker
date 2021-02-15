package com.cloudleaf.tracking.aftership.entity;

public class AfterShipTrackingResponse {

	private Meta meta;
	private Data data;

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Meta getMeta() {
		return this.meta;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Data getData() {
		return this.data;
	}
}
