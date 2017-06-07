package com.wmc.app.mobilevers;

import java.rmi.RemoteException;
import java.text.DecimalFormat;

import psdi.mbo.*;
import psdi.util.MXApplicationException;
import psdi.util.MXException;

/** com.wmc.app.mobilevers.FldMVVersion
 * @author 蒋カイセキ    Japan-Tokyo  2017年5月17日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class FldMVVersion extends MboValueAdapter{
	
	public FldMVVersion(MboValue mbv){
		super(mbv);
	}
	
	
	@Override
	public void action() throws MXException, RemoteException {
		// TODO Auto-generated method stub
		psdi.app.workorder.FailureReportSet asdf;
		com.wmc.app.defect.FldAssetnum sadf;
		psdi.app.workorder.FldWOAssetnum saf;

		super.action();
		String name = getMboValue().getName();
		Mbo mbo = getMboValue().getMbo();
		
		switch (name) {
		case "VERSION":
			if(mbo.isNull("version")){
				mbo.setValueNull("VERSION1");
				mbo.setValueNull("VERSION2");
				mbo.setValueNull("VERSION3");
			}else{
				String version = mbo.getString("VERSION");
				if(version.indexOf("。")!=-1){
					throw new MXApplicationException("#","你他妈的别再用中文标点了");
				}
				String[] split = version.split("\\.");
				if(split.length!=3){
					throw new MXApplicationException("#","版本号为 x.x.x");
				};
				try {
					mbo.setValue("VERSION1", new Integer(split[0]),11L);
					mbo.setValue("VERSION2", new Integer(split[1]),11L);
					mbo.setValue("VERSION3", new Integer(split[2]),11L);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					throw new MXApplicationException("#","版本号为 x.x.x,数字转换出\n错"+e.getMessage());
				}
			}
			break;

		case "VERSION1":
			if(!mbo.isNull("version1")&&!mbo.isNull("version2")&&!mbo.isNull("version3")){
				int version1 = mbo.getInt("VERSION1");
				int version2 = mbo.getInt("VERSION2");
				int version3 = mbo.getInt("VERSION3");
				mbo.setValue("VERSION",version1+"."+version2+"."+version3,MboConstants.NOACCESSCHECK+MboConstants.NOVALIDATION_AND_NOACTION);
			}
			break;
		case "VERSION2":
			if(!mbo.isNull("version1")&&!mbo.isNull("version2")&&!mbo.isNull("version3")){
				int version1 = mbo.getInt("VERSION1");
				int version2 = mbo.getInt("VERSION2");
				int version3 = mbo.getInt("VERSION3");
				mbo.setValue("VERSION",version1+"."+version2+"."+version3,MboConstants.NOACCESSCHECK+MboConstants.NOVALIDATION_AND_NOACTION);
			}
			break;
		case "VERSION3":
			if(!mbo.isNull("version1")&&!mbo.isNull("version2")&&!mbo.isNull("version3")){
				int version1 = mbo.getInt("VERSION1");
				int version2 = mbo.getInt("VERSION2");
				int version3 = mbo.getInt("VERSION3");
				mbo.setValue("VERSION",version1+"."+version2+"."+version3,MboConstants.NOACCESSCHECK+MboConstants.NOVALIDATION_AND_NOACTION);
			}
			break;
		default:
			break;
		}
		
			if(!mbo.isNull("version1")&&!mbo.isNull("version2")&&!mbo.isNull("version3")){
				
				long versionnum = mbo.getLong("version1")*1000000+mbo.getLong("version2")*1000+mbo.getLong("version3");
				mbo.setValue("VERSIONNUM", versionnum);
			}
	}
	
}
