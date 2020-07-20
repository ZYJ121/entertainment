package com.entertainment.test.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @Description: 
 * @Date: Created inFri Jul 17 23:29:46 CST 2020
 * @Author: zhou
 * @Modified By:
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table ( name ="drama_week" )
public class DramaWeekEntity  implements Serializable {

	private static final long serialVersionUID =  697499286017670741L;

   	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**节目的ID*/
   	@Column(name = "drama_series_id" )
	private Integer dramaSeriesId;

	/**节目周几更新*/
   	@Column(name = "week" )
	private Integer week;

}
