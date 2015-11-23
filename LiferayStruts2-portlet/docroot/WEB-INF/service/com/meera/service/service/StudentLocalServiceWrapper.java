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

package com.meera.service.service;

/**
 * <p>
 * This class is a wrapper for {@link StudentLocalService}.
 * </p>
 *
 * @author    meera prince
 * @see       StudentLocalService
 * @generated
 */
public class StudentLocalServiceWrapper implements StudentLocalService {
	public StudentLocalServiceWrapper(StudentLocalService studentLocalService) {
		_studentLocalService = studentLocalService;
	}

	/**
	* Adds the student to the database. Also notifies the appropriate model listeners.
	*
	* @param student the student to add
	* @return the student that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.service.model.Student addStudent(
		com.meera.service.model.Student student)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentLocalService.addStudent(student);
	}

	/**
	* Creates a new student with the primary key. Does not add the student to the database.
	*
	* @param studentId the primary key for the new student
	* @return the new student
	*/
	public com.meera.service.model.Student createStudent(long studentId) {
		return _studentLocalService.createStudent(studentId);
	}

	/**
	* Deletes the student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student to delete
	* @throws PortalException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteStudent(long studentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_studentLocalService.deleteStudent(studentId);
	}

	/**
	* Deletes the student from the database. Also notifies the appropriate model listeners.
	*
	* @param student the student to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteStudent(com.meera.service.model.Student student)
		throws com.liferay.portal.kernel.exception.SystemException {
		_studentLocalService.deleteStudent(student);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _studentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the student with the primary key.
	*
	* @param studentId the primary key of the student to get
	* @return the student
	* @throws PortalException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.service.model.Student getStudent(long studentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studentLocalService.getStudent(studentId);
	}

	/**
	* Gets a range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of students to return
	* @param end the upper bound of the range of students to return (not inclusive)
	* @return the range of students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.service.model.Student> getStudents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentLocalService.getStudents(start, end);
	}

	/**
	* Gets the number of students.
	*
	* @return the number of students
	* @throws SystemException if a system exception occurred
	*/
	public int getStudentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentLocalService.getStudentsCount();
	}

	/**
	* Updates the student in the database. Also notifies the appropriate model listeners.
	*
	* @param student the student to update
	* @return the student that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.service.model.Student updateStudent(
		com.meera.service.model.Student student)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentLocalService.updateStudent(student);
	}

	/**
	* Updates the student in the database. Also notifies the appropriate model listeners.
	*
	* @param student the student to update
	* @param merge whether to merge the student with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the student that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.service.model.Student updateStudent(
		com.meera.service.model.Student student, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentLocalService.updateStudent(student, merge);
	}

	public StudentLocalService getWrappedStudentLocalService() {
		return _studentLocalService;
	}

	private StudentLocalService _studentLocalService;
}