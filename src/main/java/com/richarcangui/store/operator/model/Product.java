package com.richarcangui.store.operator.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {
	private String id;
	private String image;
	private String name;
	private String description;
	private String price;
	private String category;
	private String type;
}
