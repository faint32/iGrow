/**
* @FileName BasicEnums.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-24 上午10:14:06
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

/**
 * @ClassName BasicEnums
 * @Description TODO【基本枚举】
 * @Author Brights
 * @Date 2013-10-24 上午10:14:06
 */
public class BasicEnums {
	
	// 小数位精确方式(四舍五入、向上取整、向下取整)
		public enum RoundType {
			roundHalfUp, roundUp, roundDown
		}
		
		// 运算符(加、减、乘、除)
		public enum Operator {
			add, subtract, multiply, divide
		}

}
