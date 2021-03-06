package com.harmonycloud.repository;


import com.harmonycloud.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    /**
     * 根据 patient id 查询该病人的预约情况
     *
     * @param patientId patientId
     * @return List
     */
    List<Appointment> findByPatientId(Integer patientId);

    /**
     * 查询病人是否已有相同的预约记录
     *
     * @param patientId       patientId
     * @param encounterTypeId encounterTypeId
     * @param roomId          roomId
     * @return List
     */
    @Query(nativeQuery = true, value = "select * from \"appointment\" where \"patient_id\" = ?1 and \"encounter_type_id\" =?2\n" +
            "                              and \"room_id\" =?3 and \"attendance_status\" = ?4 and \"appointment_date\"  > to_date(?5,'yyyy-mm-dd')")
    List<Appointment> findAppointment(Integer patientId, Integer encounterTypeId, Integer roomId, String attendanceStatus, String appointmentDate);


    Appointment findByAppointmentId(Integer appointmentId);

    @Query(nativeQuery = true, value = "select * from \"appointment\" where to_char(\"appointment_date\",'yyyy-MM-dd') like concat(?1,'%')")
    List<Appointment> findByappointmentDate(String appointmentDate);

    @Query(nativeQuery = true, value = "select * from \"appointment\" where \"room_id\"=?1 and to_char(\"appointment_date\",'yyyy-MM-dd') like concat(?2,'%')")
    List<Appointment> findByroomIdAndDate(Integer roomId, String appointmentDate);

    @Query(nativeQuery = true, value = "select * from \"appointment\" where \"attendance_status\"=?1  and to_char(\"appointment_date\",'yyyy-MM-dd') like concat(?2,'%')")
    List<Appointment> findBystatusAndDate(String attendanceStatus, String appointmentDate);

    @Query(nativeQuery = true, value = "select * from \"appointment\" where \"attendance_status\"=?2 " +
            "and \"room_id\"=?1 and to_char(\"appointment_date\",'yyyy-MM-dd') like concat(?3,'%')")
    List<Appointment> findByroomIdAndSatusAndDate(Integer roomId, String attendanceStatus, String appointmentDate);
}
