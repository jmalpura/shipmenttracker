package com.cloudleaf.tracking.aftership.entity;

import java.util.List;

public class Tracking {
	private String id;

	private String created_at;

	private String updated_at;

	private String last_updated_at;

	private String tracking_number;

	private String slug;

	private boolean active;

	private List<String> android;

	private String custom_fields;

	private String customer_name;

	private int delivery_time;

	private String destination_country_iso3;

	private String courier_destination_country_iso3;

	private List<String> emails;

	private String expected_delivery;

	private List<String> ios;

	private String note;

	private String order_id;

	private String order_id_path;

	private String order_date;

	private String origin_country_iso3;

	private String shipment_package_count;

	private String shipment_pickup_date;

	private String shipment_delivery_date;

	private String shipment_type;

	private String shipment_weight;

	private String shipment_weight_unit;

	private String signed_by;

	private List<String> smses;

	private String source;

	private String tag;

	private String subtag;

	private String subtag_message;

	private String title;

	private int tracked_count;

	private String last_mile_tracking_supported;

	private String language;

	private String unique_token;

	private List<String> checkpoints;

	private List<String> subscribed_smses;

	private List<String> subscribed_emails;

	private boolean return_to_sender;

	private String order_promised_delivery_date;

	private String delivery_type;

	private String pickup_location;

	private String pickup_note;

	private String courier_tracking_link;

	private String first_attempted_at;

	private String courier_redirect_link;

	private String tracking_account_number;

	private String tracking_origin_country;

	private String tracking_destination_country;

	private String tracking_key;

	private String tracking_postal_code;

	private String tracking_ship_date;

	private String tracking_state;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getCreated_at() {
		return this.created_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getUpdated_at() {
		return this.updated_at;
	}

	public void setLast_updated_at(String last_updated_at) {
		this.last_updated_at = last_updated_at;
	}

	public String getLast_updated_at() {
		return this.last_updated_at;
	}

	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}

	public String getTracking_number() {
		return this.tracking_number;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getSlug() {
		return this.slug;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setAndroid(List<String> android) {
		this.android = android;
	}

	public List<String> getAndroid() {
		return this.android;
	}

	public void setCustom_fields(String custom_fields) {
		this.custom_fields = custom_fields;
	}

	public String getCustom_fields() {
		return this.custom_fields;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_name() {
		return this.customer_name;
	}

	public void setDelivery_time(int delivery_time) {
		this.delivery_time = delivery_time;
	}

	public int getDelivery_time() {
		return this.delivery_time;
	}

	public void setDestination_country_iso3(String destination_country_iso3) {
		this.destination_country_iso3 = destination_country_iso3;
	}

	public String getDestination_country_iso3() {
		return this.destination_country_iso3;
	}

	public void setCourier_destination_country_iso3(String courier_destination_country_iso3) {
		this.courier_destination_country_iso3 = courier_destination_country_iso3;
	}

	public String getCourier_destination_country_iso3() {
		return this.courier_destination_country_iso3;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<String> getEmails() {
		return this.emails;
	}

	public void setExpected_delivery(String expected_delivery) {
		this.expected_delivery = expected_delivery;
	}

	public String getExpected_delivery() {
		return this.expected_delivery;
	}

	public void setIos(List<String> ios) {
		this.ios = ios;
	}

	public List<String> getIos() {
		return this.ios;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return this.note;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getOrder_id() {
		return this.order_id;
	}

	public void setOrder_id_path(String order_id_path) {
		this.order_id_path = order_id_path;
	}

	public String getOrder_id_path() {
		return this.order_id_path;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getOrder_date() {
		return this.order_date;
	}

	public void setOrigin_country_iso3(String origin_country_iso3) {
		this.origin_country_iso3 = origin_country_iso3;
	}

	public String getOrigin_country_iso3() {
		return this.origin_country_iso3;
	}

	public void setShipment_package_count(String shipment_package_count) {
		this.shipment_package_count = shipment_package_count;
	}

	public String getShipment_package_count() {
		return this.shipment_package_count;
	}

	public void setShipment_pickup_date(String shipment_pickup_date) {
		this.shipment_pickup_date = shipment_pickup_date;
	}

	public String getShipment_pickup_date() {
		return this.shipment_pickup_date;
	}

	public void setShipment_delivery_date(String shipment_delivery_date) {
		this.shipment_delivery_date = shipment_delivery_date;
	}

	public String getShipment_delivery_date() {
		return this.shipment_delivery_date;
	}

	public void setShipment_type(String shipment_type) {
		this.shipment_type = shipment_type;
	}

	public String getShipment_type() {
		return this.shipment_type;
	}

	public void setShipment_weight(String shipment_weight) {
		this.shipment_weight = shipment_weight;
	}

	public String getShipment_weight() {
		return this.shipment_weight;
	}

	public void setShipment_weight_unit(String shipment_weight_unit) {
		this.shipment_weight_unit = shipment_weight_unit;
	}

	public String getShipment_weight_unit() {
		return this.shipment_weight_unit;
	}

	public void setSigned_by(String signed_by) {
		this.signed_by = signed_by;
	}

	public String getSigned_by() {
		return this.signed_by;
	}

	public void setSmses(List<String> smses) {
		this.smses = smses;
	}

	public List<String> getSmses() {
		return this.smses;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return this.source;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return this.tag;
	}

	public void setSubtag(String subtag) {
		this.subtag = subtag;
	}

	public String getSubtag() {
		return this.subtag;
	}

	public void setSubtag_message(String subtag_message) {
		this.subtag_message = subtag_message;
	}

	public String getSubtag_message() {
		return this.subtag_message;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTracked_count(int tracked_count) {
		this.tracked_count = tracked_count;
	}

	public int getTracked_count() {
		return this.tracked_count;
	}

	public void setLast_mile_tracking_supported(String last_mile_tracking_supported) {
		this.last_mile_tracking_supported = last_mile_tracking_supported;
	}

	public String getLast_mile_tracking_supported() {
		return this.last_mile_tracking_supported;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setUnique_token(String unique_token) {
		this.unique_token = unique_token;
	}

	public String getUnique_token() {
		return this.unique_token;
	}

	public void setCheckpoints(List<String> checkpoints) {
		this.checkpoints = checkpoints;
	}

	public List<String> getCheckpoints() {
		return this.checkpoints;
	}

	public void setSubscribed_smses(List<String> subscribed_smses) {
		this.subscribed_smses = subscribed_smses;
	}

	public List<String> getSubscribed_smses() {
		return this.subscribed_smses;
	}

	public void setSubscribed_emails(List<String> subscribed_emails) {
		this.subscribed_emails = subscribed_emails;
	}

	public List<String> getSubscribed_emails() {
		return this.subscribed_emails;
	}

	public void setReturn_to_sender(boolean return_to_sender) {
		this.return_to_sender = return_to_sender;
	}

	public boolean getReturn_to_sender() {
		return this.return_to_sender;
	}

	public void setOrder_promised_delivery_date(String order_promised_delivery_date) {
		this.order_promised_delivery_date = order_promised_delivery_date;
	}

	public String getOrder_promised_delivery_date() {
		return this.order_promised_delivery_date;
	}

	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}

	public String getDelivery_type() {
		return this.delivery_type;
	}

	public void setPickup_location(String pickup_location) {
		this.pickup_location = pickup_location;
	}

	public String getPickup_location() {
		return this.pickup_location;
	}

	public void setPickup_note(String pickup_note) {
		this.pickup_note = pickup_note;
	}

	public String getPickup_note() {
		return this.pickup_note;
	}

	public void setCourier_tracking_link(String courier_tracking_link) {
		this.courier_tracking_link = courier_tracking_link;
	}

	public String getCourier_tracking_link() {
		return this.courier_tracking_link;
	}

	public void setFirst_attempted_at(String first_attempted_at) {
		this.first_attempted_at = first_attempted_at;
	}

	public String getFirst_attempted_at() {
		return this.first_attempted_at;
	}

	public void setCourier_redirect_link(String courier_redirect_link) {
		this.courier_redirect_link = courier_redirect_link;
	}

	public String getCourier_redirect_link() {
		return this.courier_redirect_link;
	}

	public void setTracking_account_number(String tracking_account_number) {
		this.tracking_account_number = tracking_account_number;
	}

	public String getTracking_account_number() {
		return this.tracking_account_number;
	}

	public void setTracking_origin_country(String tracking_origin_country) {
		this.tracking_origin_country = tracking_origin_country;
	}

	public String getTracking_origin_country() {
		return this.tracking_origin_country;
	}

	public void setTracking_destination_country(String tracking_destination_country) {
		this.tracking_destination_country = tracking_destination_country;
	}

	public String getTracking_destination_country() {
		return this.tracking_destination_country;
	}

	public void setTracking_key(String tracking_key) {
		this.tracking_key = tracking_key;
	}

	public String getTracking_key() {
		return this.tracking_key;
	}

	public void setTracking_postal_code(String tracking_postal_code) {
		this.tracking_postal_code = tracking_postal_code;
	}

	public String getTracking_postal_code() {
		return this.tracking_postal_code;
	}

	public void setTracking_ship_date(String tracking_ship_date) {
		this.tracking_ship_date = tracking_ship_date;
	}

	public String getTracking_ship_date() {
		return this.tracking_ship_date;
	}

	public void setTracking_state(String tracking_state) {
		this.tracking_state = tracking_state;
	}

	public String getTracking_state() {
		return this.tracking_state;
	}
}
