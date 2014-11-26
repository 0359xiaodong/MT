package org.fireking.app.mt.model;

import java.io.Serializable;

/**
 * ���������Ƽ��б����
 * 
 * @author join
 *
 */
public class ShopPanicBuyEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Ψһ��ʾ
	 */
	private int id;

	/***
	 * ͼƬ��ַ
	 */
	private String imagePath;

	/**
	 * ��������
	 */
	private String name;

	/**
	 * ԭ��
	 */
	private String original_price;

	/**
	 * �ۿۼ�
	 */
	private String discount_price;

	public ShopPanicBuyEntity() {
		super();
	}

	public ShopPanicBuyEntity(int id, String imagePath, String name,
			String original_price, String discount_price) {
		super();
		this.id = id;
		this.imagePath = imagePath;
		this.name = name;
		this.original_price = original_price;
		this.discount_price = discount_price;
	}

	@Override
	public String toString() {
		return "ShopPanicBuyEntity [id=" + id + ", imagePath=" + imagePath
				+ ", name=" + name + ", original_price=" + original_price
				+ ", discount_price=" + discount_price + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(String original_price) {
		this.original_price = original_price;
	}

	public String getDiscount_price() {
		return discount_price;
	}

	public void setDiscount_price(String discount_price) {
		this.discount_price = discount_price;
	}

}
