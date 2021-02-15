package com.cloudleaf.tracking.aftership.entity;

import java.util.List;

import lombok.Data;

@Data
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

}
