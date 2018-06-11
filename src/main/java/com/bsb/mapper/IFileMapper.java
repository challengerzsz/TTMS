package com.bsb.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface IFileMapper {

    @Update("UPDATE user_table SET img = #{saveFilePath} WHERE id = #{id}")
    int insertSaveFilePath(@Param("saveFilePath") String saveFilePath,
                           @Param("id") int id);
}
