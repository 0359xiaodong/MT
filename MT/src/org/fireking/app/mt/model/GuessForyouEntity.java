package org.fireking.app.mt.model;

import java.io.Serializable;

/**
 * ����ϲ���Ƽ�����ʵ����
 * 
 * @author join
 *
 */
public class GuessForyouEntity implements Serializable {

	/**
	 * ���
	 */
	private int id;
	/**
	 * ����ͼ
	 */
	private String image;
	/**
	 * ����
	 */
	private String title;
	/**
	 * ��������
	 */
	private String description;
	/**
	 * ԭ��
	 */
	private String original_price;
	/**
	 * �ۿۼ�/�����Ż���Ϣ
	 */
	private String discount_price;
	/**
	 * ��������
	 */
	private String sale_count;

	public GuessForyouEntity() {
		super();
	}

	public GuessForyouEntity(int id, String image, String title,
			String description, String original_price, String discount_price,
			String sale_count) {
		super();
		this.id = id;
		this.image = image;
		this.title = title;
		this.description = description;
		this.original_price = original_price;
		this.discount_price = discount_price;
		this.sale_count = sale_count;
	}

	@Override
	public String toString() {
		return "GuessForyouEntity [id=" + id + ", image=" + image + ", title="
				+ title + ", description=" + description + ", original_price="
				+ original_price + ", discount_price=" + discount_price
				+ ", sale_count=" + sale_count + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getSale_count() {
		return sale_count;
	}

	public void setSale_count(String sale_count) {
		this.sale_count = sale_count;
	}

}
