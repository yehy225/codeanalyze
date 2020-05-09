package com.yehongyu.checkcode;

/**
 * 关于对bit操作的Flag标识位方法
 * @author yingyang
 * @since 2011-10-14
 */
public class FlagUtil {
	
	private static final int BASE = 2; // 按位与标识位基数
	
    /**
     * @deprecated use <code>(src == 0)</code> instead
     */
    public static final long B0 = 0;

	/**
	 * 位常量值，不表示任何意思，由各业务字段自己定义
	 * 请不要使用以下常量，仅供参考
	 * 目前有使用的 businessScope（请参考TripAgentConstants);flag（请参考TripAgentConstants）
	 * ,etFlag（请参考ET业务）,ieFlag（ 请参考Ie业务）
	 */
    public static final long B1 = (long) Math.pow(BASE, 0); // =2^0=1
    public static final long B2 = (long) Math.pow(BASE, 1); // =2^1=2
    public static final long B3 = (long) Math.pow(BASE, 2); // =2^2=4
    public static final long B4 = (long) Math.pow(BASE, 3); // =2^3=8
    public static final long B5 = (long) Math.pow(BASE, 4); // =2^4=16
    public static final long B6 = (long) Math.pow(BASE, 5); // =2^5=32
    public static final long B7 = (long) Math.pow(BASE, 6); // =2^6=64
    public static final long B8 = (long) Math.pow(BASE, 7); // =2^7=128
    public static final long B9 = (long) Math.pow(BASE, 8); // =2^8=256
    public static final long B10 = (long) Math.pow(BASE, 9); // =2^9=512
    public static final long B11 = (long) Math.pow(BASE, 10); // =2^10=1024
    public static final long B12 = (long) Math.pow(BASE, 11); // =2^11=2048
    public static final long B13 = (long) Math.pow(BASE, 12); // =2^12=4096
    public static final long B14 = (long) Math.pow(BASE, 13); // =2^13=8192
    public static final long B15 = (long) Math.pow(BASE, 14); // =2^14=16384
    public static final long B16 = (long) Math.pow(BASE, 15); // =2^15=
    public static final long B17 = (long) Math.pow(BASE, 16); //= 2^16=
    public static final long B18 = (long) Math.pow(BASE, 17); //= 2^17=
    public static final long B19 = (long) Math.pow(BASE, 18); //= 2^18=
    public static final long B20 = (long) Math.pow(BASE, 19); //= 2^19=
    public static final long B21 = (long) Math.pow(BASE, 20); //= 2^20=1048576
    public static final long B22 = (long) Math.pow(BASE, 21); //= 2^21=
	
	/**
	 * 判断源标识里是否包含目标标识位,如果包含返回True
	 * @param source
	 * @param target
	 * @return true or false
	 */
	public static boolean isBinaryBitMatched(Long source, Long target) {
		//如果传入空值，则默认为0
		if (source == null) source = 0L;
		if (target == null) target = 0L;
        return (source & target) == target;
    }
	
	/**
	 * 判断源标识里是否未包含目标标识位,如果未包含返回True
	 * @param source
	 * @param target
	 * @return true or false
	 */
	public static boolean isBinaryBitNotMatched(Long source, Long target) {
		//如果传入空值，则默认为0
		if (source == null) source = 0L;
		if (target == null) target = 0L;
        return (source & target) == 0;
    }
	
	/**
	 * 在 flag 里加入 bit 位
	 * @param flag
	 * @param bit
	 * @return 加入后的 flag
	 */
	public static long onBit(Long flag,Long bit){
		if(flag==null)flag=0L;
		if(bit==null)bit=0L;
    	return flag |= bit;
    }
	
	/**
	 * 在 flag 里去除 bit 位
	 * @param flag
	 * @param bit
	 * @return 去除后的 flag
	 */
	public static long offBit(Long flag,Long bit){
		if(flag==null)flag=0L;
		if(bit==null)bit=0L;
    	return flag &= ~bit;
    }
	
	public static void main(String[] args){
		long flag = 0L;
		System.out.println(flag);
		long f = FlagUtil.onBit(flag, B1);
		System.out.println(flag);
		System.out.println(f);
		
	}

}
