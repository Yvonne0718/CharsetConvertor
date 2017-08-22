package filter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileFilter {
	
	
	
	public List<File> adFileFilter(List<File> filelist, List<String> adType){
		System.out.println("进adfilter总数："+filelist.size());
		List<File> temp = new ArrayList<File>();
		for(int i=0;i<filelist.size();i++){
			 boolean flag = false;
			 String[] splitArray = filelist.get(i).getPath().split("\\.");
			 String suffix = splitArray[splitArray.length-1];
			 for(int j=0;j<adType.size();j++){
				 if(suffix.equals(adType.get(j))){
					 flag = true;
					 break;
				 }
			 }
			 if(!flag){
				 temp.add(filelist.get(i));
				 flag = false;
			 }
		}
		System.out.println("出adFilter总数："+filelist.size());
		return temp;
	}
	
	public List<File> tgFilesFilter(List<File> files,List<String> tgtype){
		System.out.println("进tgfilter总数："+files.size());
//		this.temp.removeAll(this.temp);
		List<File> temp = new ArrayList<File>();
		for(int i=0;i<files.size();i++){
//			 boolean flag = false;
			 String[] splitArray = files.get(i).getPath().split("\\.");
			 String suffix = splitArray[splitArray.length-1];
			 for(int j=0;j<tgtype.size();j++){
				 if(suffix.equals(tgtype.get(j))){
					temp.add(files.get(i));
				 }
//				 flag = true;
			 }
//			 if(flag){
//				 files.remove(i);
//				 flag = false;
//			 }
		}
		System.out.println("出tgFilter总数："+temp.size());
		return temp;
	}
	
//	private List<File> tgFileFilter(File dir,String[] suffix){
//		
//			List<File> files = new ArrayList<File>();
//			
////			File dir = new File(realpath);
//			File[] filelist = dir.listFiles();
//			if(suffix==null || suffix[0].equals("") || suffix.length == 0){
//				for(int b=0;b<filelist.length;b++){
//					if(filelist[b].isDirectory()){
////						String path = filelist[b].getPath();
//						files.addAll(tgFileFilter(filelist[b],suffix));
//					}else if(filelist[b].isFile()){
////						String path = filelist[b].getPath();
//						files.add(filelist[b]);
//					}
//				}
//			}else{
//					for(int i=0;i<filelist.length;i++){
//						if(filelist[i].isDirectory()){
////							String path = filelist[i].getPath();
//							files.addAll(tgFileFilter(filelist[i],suffix));
//						}else if(filelist[i].isFile()){
//							String path = filelist[i].getPath();
//							String[] split = path.split("\\.");
//							String filetype = split[split.length-1];
//							for(int a=0;a<suffix.length;a++){
//								if(filetype.equals(suffix[a])){
//									files.add(filelist[i]);
//			//						System.out.println(path);
//									break;
//								}
//							}
//							
//						}
//					}
//			}
//			
//			return files;
//	}
	

	public List<File> hiveFileFilter(List<File> filelist) {
		System.out.println("进hivefilter总数："+filelist.size());
//		this.temp.removeAll(this.temp);
		List<File> temp = new ArrayList<File>();
		for(int i=0;i<filelist.size();i++){
//			 boolean flag = false;
			 String[] splitArray = filelist.get(i).getPath().replaceAll("\\\\", "/").split("/\\.");
			 if(splitArray.length>1){
				 continue;
			 }else if(splitArray.length == 1){
				 temp.add(filelist.get(i));
			 }
				 
		}
		System.out.println("出hiveFilter总数："+temp.size());
		
		return temp;
	}

	public List<File> allfile(File[] tempFile) {
		List<File> f  = new ArrayList<File>();
//		System.out.println(tempFile.length);
//		if(tempFile.length==1){
//			f.addAll(allfile(tempFile[0].listFiles()));
//		}
		for(int i=0;i<tempFile.length;i++){
			if(tempFile[i].isDirectory()){
				f.addAll(allfile(tempFile[i].listFiles()));
			}else if(tempFile[i].isFile()){
				f.add(tempFile[i]);
			}
		}
		return f;
	}
}
