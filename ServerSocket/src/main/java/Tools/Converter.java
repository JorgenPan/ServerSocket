package Tools;

import java.util.Locale;

/**
 * 转换类
 * @author JorgenPan
 */
public class Converter {

	
	public static String Encoding = "GBK";


	/**
	 * 十六进制字符串转换成普通字符串
	 * @param hex
	 * @return
	 */
	public String hex2String(String hex){
		byte[] bytes = Converter.hexToBytes(hex);
		return Converter.toString(bytes);
	}
	
	

	/**
	 * 十六进制字符串转换成字节数组
	 * @param hex
	 * @return 
	 */
	private static byte[] hexToBytes(String hex) {
		hex = hex.replaceAll("0x", "");
		hex = hex.replaceAll(" ", "");
		
		String[] tmps = new String[ hex.length() /2 ];
		
		for(int i = 0 ; i < tmps.length ; i++ ){
			tmps[i] = hex.substring(i * 2 , i * 2 + 2);
		}
		byte[] bytes = new byte[tmps.length];
		
		for(int j = 0 ; j < tmps.length ; j++ ){
			if(tmps[j].trim().length() == 2){
				bytes[j] = Integer.valueOf( tmps[j], 16).byteValue();
			}
		}
		return bytes;
	}
	
	/**
	 * 字节数组转换成字符串
	 * @param bytes
	 * @return
	 */
	private static String toString(byte[] bytes){
		try {
			if( bytes == null ){
				return null;
			}
			return new String( bytes, Encoding);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 字节数组转换为十六进制字符串
	 * @param bytes
	 * @param separator
	 * @return
	 */
	public static String toHexString( byte[] bytes, String separator){
		return toHexString( bytes, 0, bytes.length, separator);
	}


	/**
	 * 字节数组转换为十六进制字符串
	 * @param bytes
	 * @param i
	 * @param length
	 * @param separator
	 * @return
	 */
	private static String toHexString(byte[] bytes, int startIndex, int length, String separator) {
		if( bytes == null || bytes.length == 0 ){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		String tmp = "";
		for(int i = 0 ; i < length ; i++ ){
			tmp = Integer.toHexString(bytes[ i + startIndex ]).toUpperCase(Locale.getDefault());
			if( tmp.length() > 2 ){
				tmp = tmp.substring( tmp.length() -2, tmp.length());
			}else if( tmp.length() < 2 ){
				tmp = "0" + tmp;
			}
			sb.append( separator + tmp );
		}
		return sb.toString();
	}
	
	
	/**
	 * 左边补字节0
	 * @param buffer
	 * @param size
	 * @param b
	 * @return
	 */
	private static byte[] leftPad( byte[] buffer, int size, byte b){
		int len = buffer.length;
		if( len > size ){
			len = size;
		}
		byte[] bytes = new byte[size];
		for(int i = 0 ; i < bytes.length ; i++){
			bytes[i] = b;
		}
		System.arraycopy(buffer, 0, bytes, size - len, len);
		return bytes;
	}
	
	
	/**
	 * 右边补字节0
	 * @param buffer
	 * @param size
	 * @param b
	 * @return
	 */
	private static byte[] rightPad( byte[] buffer, int size, byte b){
		int len = buffer.length;
		if( len > size ){
			len = size;
		}
		byte[] bytes = new byte[size];
		for(int i = 0 ; i < bytes.length ; i++){
			bytes[i] = b;
		}
		System.arraycopy(buffer, 0, bytes, 0, len);
		return bytes;
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static String ToSBC(String input){
		
	}
}
