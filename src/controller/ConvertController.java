package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import convertor.Convertor;
import filter.FileFilter;
import ui.Logger;

public class ConvertController {
	
    /**
	 * 用户最初选定的所有的file
	 */
	private File[] tempFile;
	
	/**
	 * 过滤类型
	 */
	private List<String> adType = new ArrayList<String>();
	 
	/**
	 * 目标类型
	 */
	private List<String> tgType = new ArrayList<String>();
	
	/**
	 * 是否选中隐藏文件
	 */
	private boolean hive = false;
	
	/**
	 * 默认转换编码UTF-8
	 */
	private String tgEncoding = "UTF-8";
	
	/**
	 * 过滤器筛选后的file
	 */
	private List<File> filelist;
	
	/**
	 * 日志管理器
	 */
	private Logger logger;

	
	private FileFilter filter = new FileFilter();
	private Convertor convertor = new Convertor();

    public String tgdir_temp="";
    public String tgtype_temp = "";
    public String adtype_temp = "";
	private static ConvertController convertController = new ConvertController();
	private ConvertController(){
		
	}
	
	public static ConvertController getInstence() {
		return convertController;
	}
	
	public boolean query(boolean islog) {
		boolean flag=false;
		try{
			if(tempFile==null){
				this.logger.log("请先选择需要转换编码的文件");
				return false;
			}
//			System.out.println("query: hive : "+this.hive+"  adType : "+this.adType.toString()+" tgtype :　"+this.tgType.toString());
			this.filterChain(tempFile,islog);
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
//			this.logger.log(e.getMessage());
			this.logger.space();
		}
		return flag;
	}
	
	
	
	public void filterChain(File[] files,boolean islog){
		
		filelist = this.filter.allfile(this.tempFile);
		System.out.println("进chain总数 : "+filelist.size());
		if(!this.hive){
			filelist = this.filter.hiveFileFilter(this.filelist);
		}
		if(this.tgType.size() != 0 ){
			filelist = this.filter.tgFilesFilter(this.filelist, this.tgType);
		}
		if((this.tgType.size() == 0 || (this.tgType.size() == 1 && this.tgType.contains(""))) && this.adType.size() != 0){
			filelist = this.filter.adFileFilter(this.filelist, this.adType);
		}
		
		if(islog){
			this.logger.log("命中文件"+this.filelist.size()+"个:\n");
			for(int i=0;i<this.filelist.size();i++){
				String ogEncoding = this.encodingDetect(filelist.get(i));
				this.logger.log(this.filelist.get(i).getPath()+"  "+"源编码 : "+ogEncoding);
			}
			
			this.logger.space();
		}
		
		System.out.println("出chain总数： "+filelist.size());
		
		
	}
	
	public void encodingConvertStart(){
//		File[] fa = new File[this.pathlist.size()];
//		this.logger.space();
		if(this.query(false)){
			logger.log("开始将文件转换成\""+tgEncoding+"\"格式\n");
			
			int finish = 0;
			for(int i=0;i<this.filelist.size();i++){
				String ogEncoding = this.encodingDetect(filelist.get(i));
				logger.log(filelist.get(i).getPath()+"   "+ogEncoding+"----->"+tgEncoding);
				finish = finish + this.convertor.singleFileConvert(filelist.get(i), ogEncoding, tgEncoding);
			}
			this.logger.log("\n");
			this.logger.log("命中文件总数为："+this.filelist.size());
			this.logger.log("转换成功文件个数为："+finish+"\n");
			
			this.logger.space();
		}
		
	}
	
	private String encodingDetect(File f){
		return this.convertor.encodingDetect(f);
	}

	
//	public void setOgEncoding(String ogEncoding) {
//		this.ogEncoding = ogEncoding;
//	}


	public void setTgEncoding(String tgEncoding) {
		System.out.println("tgEncoding :" + tgEncoding);
		this.tgEncoding = tgEncoding;
	}


	public void setLogger(Logger logger) {
		this.logger = logger;
	}




	public void setHive(boolean hive) {
		System.out.println("hive : "+hive);
		this.hive = hive;
	}


	public void setAdType(String adTypeString) {
		System.out.println(adTypeString);
		String[] a = adTypeString.split(",");
		if(adTypeString.equals("")){
			this.adType.removeAll(this.adType);
		}else if(a.length==1 && !this.adType.contains(a[0])){
			this.adType.add(a[0]);
		}else if(a.length > 1){
			for(int i=0;i<a.length;i++){
				if(!this.adType.contains(a[i])){
					this.adType.add(a[i]);
				}
			}
		}
	}



	public void setTgType(String tgTypeString) {
		System.out.println(tgTypeString);
		String[] b = tgTypeString.split(",");
		if(tgTypeString.equals("")){
			this.tgType.removeAll(this.tgType);
		}else if(b.length == 1 && !this.tgType.contains(b[0])){
			this.tgType.add(b[0]);
		}else if(b.length > 1){
			for(int i=0;i<b.length;i++){
				if(!this.tgType.contains(b[i])){
					this.tgType.add(b[i]);
				}
				
			}
		}
	}

	/**
	 * 用户手动输入
	 * @param path
	 */
	public void setTempFile(String path){
		//TODO 验证path是否合法
//		System.out.println("触发手动设值");
		this.tempFile = new File[]{new File(path)};
	}
	
	/**
	 * 选取
	 * @param tempFile
	 */
	public void setTempFile(File[] tempFile){
//		System.out.println("触发自动设值");
		this.tempFile = tempFile;
	}

	
	
	
	
	
	
	

}
