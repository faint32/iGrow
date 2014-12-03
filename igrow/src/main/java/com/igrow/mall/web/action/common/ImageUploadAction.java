package com.igrow.mall.web.action.common;

 
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.igrow.mall.jws.constant.ImageConstants;
import com.igrow.mall.service.common.intf.ImageService;
import com.igrow.mall.util.ContentTypeUtils;
import com.igrow.mall.util.ImageUtils;
import com.igrow.mall.web.action.core.BaseAction;


/**
 * 
 * 图片上传的工具action
 * @author：shiyz
 * @date: 2013.03.19 12:42:41
 */
@Namespace("/common")
public class ImageUploadAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	@Resource(name = "imageServiceImpl")
	private ImageService imageService;
    
   
	private ByteArrayInputStream inputStream;
    private String fileFileName;
	private File file;
	private String type;//图片类型
	private Integer objectId;//所属对象的id
	 
	  /**
     * 图片上传
     * @author：shiyz
     */
 	@Action("imageupload")
	public String uploadImages()throws Exception{
		String str[] = uploadimg();
	    Map<String, String> jsonMap = new HashMap<String, String>();
	    jsonMap.put("fileName", str[0]);
	    jsonMap.put("fileId", str[1]);
		return ajax(jsonMap);
		
	}
	@Action("imageuploads")
	public String uploadImage()throws Exception{
		    Map<String, String> jsonMap = new HashMap<String, String>();
		    String fullName = uploadimgs(jsonMap);
		    jsonMap.put("fileName", fullName);
		    return ajax(jsonMap);
		
	} 
	
	private String[] uploadimg() throws IOException{
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddhhmmss");
		String filename=formater.format(new Date());
		String fileExtend = fileFileName.substring(fileFileName.lastIndexOf(".")+1,fileFileName.length());
		String root = ServletActionContext.getServletContext().getRealPath("/upload");
		String fullName=filename+"."+fileExtend;
		String dstPath = root+"/"+fullName;	//全路径

		
	    File dirFile = new File(root);
	    
	    File dirFile1 = new File(file.getPath());
	    File dirFile2 = new File(dstPath);
	    
		boolean isDir = dirFile.isDirectory();
		if(!isDir){//目录不存在则先建目录
			try{
				dirFile.mkdirs();
			}catch (Exception e) {
				File delFile = new File(root+"/"+fullName );
				deleteExitsFile(delFile);
			}
		}
		FileUtils.copyFile(dirFile1, dirFile2);//上传文件
		Integer imgId =null;
    	/*if("branch".equals(type)){
    		imgId = uploadBranchImg(fullName);
    	}else if("ring".equals(type)){
    		imgId = uploadRingImg(fullName);
    	}else if("branchRt".equals(type)){
    		imgId = uploadbranchRtImg(fullName);
    	}else if("channelImg".equals(type)){
    		imgId = uploadchannelImg(fullName);
    	}else*/ if("ckeditImg".equals(type)){//编辑器上传图片
    		imgId = uploadckeditImg(fullName);
    		fullName = "ckedit/1/"+fullName;
    	}
    	String []str = {fullName,imgId.toString()};
		return str;
	}
	
	private String uploadimgs(Map<String, String> jsonMap) throws IOException{
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddhhmmss");
		String filename=formater.format(new Date());
		String fileExtend = fileFileName.substring(fileFileName.lastIndexOf(".")+1,fileFileName.length());
		String root = ServletActionContext.getServletContext().getRealPath("/upload");
		String fullName=filename+"."+fileExtend;
		String dstPath = root+"/"+fullName;	//全路径

		
	    File dirFile = new File(root);
	    
	    File dirFile1 = new File(file.getPath());
	    File dirFile2 = new File(dstPath);
	    
	    
	
	    
		boolean isDir = dirFile.isDirectory();
		if(!isDir){//目录不存在则先建目录
			try{
				dirFile.mkdirs();
			}catch (Exception e) {
				File delFile = new File(root+"/"+fullName );
				deleteExitsFile(delFile);
			}
		}
		FileUtils.copyFile(dirFile1, dirFile2);//上传文件
		
	    // 读取源图像  
        BufferedImage bi = ImageIO.read(new File(file.getPath()));  
        int srcWidth = bi.getWidth(); // 源图宽度  
        int srcHeight = bi.getHeight(); // 源图高度            
        
	    jsonMap.put("imgUploadPath", dstPath);
	    jsonMap.put("srcWidth", srcWidth+"");
	    jsonMap.put("srcHeight", srcHeight+"");
	    
	    
		return fullName;
	}
	
/*	//上传分店图片
	private Integer uploadBranchImg(String img) {
		file = ImageUtils.getFile(img);
		String fileName = ImageUtils.getFileName(img);
		THotelBranchImg hotelImg = new THotelBranchImg();
		hotelImg.setImageName(fileName);
		String imageContentType = new ContentTypeUtils().getFileContentType(img);
    	hotelImg.setCreateTime(new Date());
    	MemberDto memberDto = (MemberDto)this.getSessionAttribute(LOGIN_INFO);
    	if(memberDto != null && memberDto.getAdmin() != null){
		  hotelImg.setCreateUser(memberDto.getAdmin().getUserName());
    	}
    	hotelImg.setBranchId(objectId.toString());
		Integer imgId = hotelBranchImgService.addHotelBranchImg(hotelImg);
    	imageService.uploadImage(ImageConstants.UPLOAD_HOTEL_BRANCH, imgId, file, imageContentType, fileName, ImageUtils.findBranchTypeStates());
    	ImageUtils.DeleteFile(img);
    	return imgId;
	}*/
	 
	
	//上传文本编辑器图片
	private Integer uploadckeditImg(String img) {
	    	file = ImageUtils.getFile(img);
			String fileName = ImageUtils.getFileName(img);
	    	String imageContentType = new ContentTypeUtils().getFileContentType(img);
    	    imageService.uploadImage(ImageConstants.UPLOAD_CKEDIT_MESSAGE, 1, file, imageContentType, fileName, ImageUtils.findCkeditContentStates());
    	    ImageUtils.DeleteFile(img);
	    	return 1;
		}
		
 
		
	
	private  void deleteExitsFile(File file) {
		if(file.exists() && file.isFile()){
			file.delete();
		}
	}
	
	/**
	 * 文本编辑器上传图片
	 * @return
	 * @throws Exception
	 */
	@Action("uploadimg")
	public String uploadImg() throws Exception {
		return "uploadimg"; 
	}
 
   	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(ByteArrayInputStream inputStream) {
		this. inputStream = inputStream;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getObjectId() {
		return objectId;
	}
	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}
	 
	 
}
	
