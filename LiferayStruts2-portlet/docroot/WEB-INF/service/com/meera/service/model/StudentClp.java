/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.meera.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author meera prince
 */
public class StudentClp extends BaseModelImpl<Student> implements Student {
	public StudentClp() {
	}

	public long getPrimaryKey() {
		return _studentId;
	}

	public void setPrimaryKey(long pk) {
		setStudentId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_studentId);
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public String getStudentName() {
		return _studentName;
	}

	public void setStudentName(String studentName) {
		_studentName = studentName;
	}

	public String getStudentPlece() {
		return _studentPlece;
	}

	public void setStudentPlece(String studentPlece) {
		_studentPlece = studentPlece;
	}

	public String getStudentState() {
		return _studentState;
	}

	public void setStudentState(String studentState) {
		_studentState = studentState;
	}

	public Student toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Student)Proxy.newProxyInstance(Student.class.getClassLoader(),
				new Class[] { Student.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		StudentClp clone = new StudentClp();

		clone.setStudentId(getStudentId());
		clone.setStudentName(getStudentName());
		clone.setStudentPlece(getStudentPlece());
		clone.setStudentState(getStudentState());

		return clone;
	}

	public int compareTo(Student student) {
		long pk = student.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		StudentClp student = null;

		try {
			student = (StudentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = student.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{studentId=");
		sb.append(getStudentId());
		sb.append(", studentName=");
		sb.append(getStudentName());
		sb.append(", studentPlece=");
		sb.append(getStudentPlece());
		sb.append(", studentState=");
		sb.append(getStudentState());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.meera.service.model.Student");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>studentId</column-name><column-value><![CDATA[");
		sb.append(getStudentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studentName</column-name><column-value><![CDATA[");
		sb.append(getStudentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studentPlece</column-name><column-value><![CDATA[");
		sb.append(getStudentPlece());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studentState</column-name><column-value><![CDATA[");
		sb.append(getStudentState());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _studentId;
	private String _studentName;
	private String _studentPlece;
	private String _studentState;
}