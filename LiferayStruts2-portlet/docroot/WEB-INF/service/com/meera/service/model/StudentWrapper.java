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

/**
 * <p>
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author    meera prince
 * @see       Student
 * @generated
 */
public class StudentWrapper implements Student {
	public StudentWrapper(Student student) {
		_student = student;
	}

	public long getPrimaryKey() {
		return _student.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_student.setPrimaryKey(pk);
	}

	public long getStudentId() {
		return _student.getStudentId();
	}

	public void setStudentId(long studentId) {
		_student.setStudentId(studentId);
	}

	public java.lang.String getStudentName() {
		return _student.getStudentName();
	}

	public void setStudentName(java.lang.String studentName) {
		_student.setStudentName(studentName);
	}

	public java.lang.String getStudentPlece() {
		return _student.getStudentPlece();
	}

	public void setStudentPlece(java.lang.String studentPlece) {
		_student.setStudentPlece(studentPlece);
	}

	public java.lang.String getStudentState() {
		return _student.getStudentState();
	}

	public void setStudentState(java.lang.String studentState) {
		_student.setStudentState(studentState);
	}

	public com.meera.service.model.Student toEscapedModel() {
		return _student.toEscapedModel();
	}

	public boolean isNew() {
		return _student.isNew();
	}

	public void setNew(boolean n) {
		_student.setNew(n);
	}

	public boolean isCachedModel() {
		return _student.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_student.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _student.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_student.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _student.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _student.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_student.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _student.clone();
	}

	public int compareTo(com.meera.service.model.Student student) {
		return _student.compareTo(student);
	}

	public int hashCode() {
		return _student.hashCode();
	}

	public java.lang.String toString() {
		return _student.toString();
	}

	public java.lang.String toXmlString() {
		return _student.toXmlString();
	}

	public Student getWrappedStudent() {
		return _student;
	}

	private Student _student;
}