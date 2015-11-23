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

package com.meera.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.meera.service.model.Student;

/**
 * The persistence interface for the student service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author meera prince
 * @see StudentPersistenceImpl
 * @see StudentUtil
 * @generated
 */
public interface StudentPersistence extends BasePersistence<Student> {
	/**
	* Caches the student in the entity cache if it is enabled.
	*
	* @param student the student to cache
	*/
	public void cacheResult(com.meera.service.model.Student student);

	/**
	* Caches the students in the entity cache if it is enabled.
	*
	* @param students the students to cache
	*/
	public void cacheResult(
		java.util.List<com.meera.service.model.Student> students);

	/**
	* Creates a new student with the primary key. Does not add the student to the database.
	*
	* @param studentId the primary key for the new student
	* @return the new student
	*/
	public com.meera.service.model.Student create(long studentId);

	/**
	* Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student to remove
	* @return the student that was removed
	* @throws com.meera.service.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.service.model.Student remove(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.service.NoSuchStudentException;

	public com.meera.service.model.Student updateImpl(
		com.meera.service.model.Student student, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the student with the primary key or throws a {@link com.meera.service.NoSuchStudentException} if it could not be found.
	*
	* @param studentId the primary key of the student to find
	* @return the student
	* @throws com.meera.service.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.service.model.Student findByPrimaryKey(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.service.NoSuchStudentException;

	/**
	* Finds the student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student to find
	* @return the student, or <code>null</code> if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.service.model.Student fetchByPrimaryKey(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the students.
	*
	* @return the students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.service.model.Student> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the students.
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
	public java.util.List<com.meera.service.model.Student> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of students to return
	* @param end the upper bound of the range of students to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.service.model.Student> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the students from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the students.
	*
	* @return the number of students
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}