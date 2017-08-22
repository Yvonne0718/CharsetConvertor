package convertor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Convertor {
	
	
	public String encodingDetect(File f){
		BytesEncodingDetect detector = new BytesEncodingDetect();
		String ogencoding = BytesEncodingDetect.javaname[detector.detectEncoding(f)];
		return ogencoding;
	}
	
	public void filesConvert(File[] files,String ogencoding,String tgencoding){
		for(int i = 0;i<files.length;i++){
			singleFileConvert(files[i],ogencoding,tgencoding);
		}
	}
	
	/**
	 * 将单个文件进行
	 * @param pathlist 文件list
	 * @throws IOException 
	 */
	public int singleFileConvert(File f,String ogencoding,String tgencoding){
		
		InputStreamReader isr ;
		BufferedReader br ;
		StringBuffer sb ;
		InputStream is ;
		OutputStream os ;
		OutputStreamWriter osw ;
		BufferedWriter bw ;
//		File f ;
		int finish = 0;
		try{
//			f = new File(singlepath);
			is = new FileInputStream(f);
			isr = new InputStreamReader(is,ogencoding);
			br = new BufferedReader(isr);
			sb = new StringBuffer();
			String line = null;
			while((line = br.readLine())!=null){
				sb.append(line);
				sb.append("\r\n");
			}
			br.close();
			isr.close();
			is.close();
//			os = new FileOutputStream(singlepath);
			os = new FileOutputStream(f);
			osw = new OutputStreamWriter(os,tgencoding);
			bw = new BufferedWriter(osw);
//			System.out.println(osw.getEncoding());
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			osw.close();
			os.close();
			finish = 1;
				
		} catch(IOException e){
			e.printStackTrace();
		}
		return finish;
	}
	
	
}
