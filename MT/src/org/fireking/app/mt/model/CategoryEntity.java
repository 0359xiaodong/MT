package org.fireking.app.mt.model;

import java.io.Serializable;

/**
 * ����ʵ����
 * 
 * @author join
 *
 */
public class CategoryEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ���
	 */
	public int id;

	/**
	 * ����
	 */
	public String name;

	/**
	 * ͼƬ
	 */
	public String images;

	/**
	 * ������Դͼ
	 */
	public int resImage;

	public CategoryEntity(int id, String name, int resImage) {
		super();
		this.id = id;
		this.name = name;
		this.resImage = resImage;
	}

}
