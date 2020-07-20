package com.entertainment.test.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.CreatedDate;

/**
 * @Description: 
 * @Date: Created inFri Jul 17 00:53:42 CST 2020
 * @Author: zhou
 * @Modified By:
 */
@Data
@Entity
// @DynamicInsert
@DynamicUpdate
@Table ( name ="drama_series" )
public class DramaSeriesEntity  implements Serializable {

	private static final long serialVersionUID =  322877508846119728L;

   	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**0国产剧，1韩剧，2日剧，3美剧，4国内综艺，5国外综艺，6动漫，7漫画，8小说*/
   	@Column(name = "type" )
	private Integer type;

	/**0已完结，1在更新，2待播*/
   	@Column(name = "series_state" )
	private Integer seriesState;

	/**感兴趣的点*/
   	@Column(name = "interest" )
	private String interest;

	/**剧照*/
   	@Column(name = "image_url" )
	private String imageUrl;

	/**周几更新（用逗号分隔）*/
   	@Column(name = "renew" )
	private String renew;

	/**在哪看剧（0爱奇艺，1B站，2韩剧TV，3网站）*/
   	@Column(name = "address" )
	private Integer address;

	/**看过之后的评价*/
   	@Column(name = "evaluate" )
	private String evaluate;

	/**创建时间*/
   	@Column(name = "create_time" )
	@CreatedDate
	private Date createTime;

	/**删除时间*/
   	@Column(name = "update_time" )
	@LastModifiedDate
	private Date updateTime;

	/**0正常状态，1删除*/
   	@Column(name = "state" )
	private Integer state;

	/**剧名*/
   	@Column(name = "name" )
	private String name;

	/**评分*/
   	@Column(name = "score" )
	private Integer score;

}
