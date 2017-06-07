package com.wmc.webclient.mobileversion

import psdi.webclient.system.beans.AppBean
import psdi.util.MXApplicationYesNoCancelException

/** com.wmc.webclient.mobileversion.MobileVersionAppBean
 * @author 蒋カイセキ    Japan-Tokyo  2017年6月2日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
open class MobileVersionAppBean:AppBean(){
	
	fun SETURL(){
		var event = this.clientSession.getCurrentEvent();
		var msgRet=event.getMessageReturn()
		when(msgRet){
			-1 ->{
				throw MXApplicationYesNoCancelException("seturl","mobileversion", "autoseturl");
			}
			MXApplicationYesNoCancelException.YES ->{
				var mbo=getMbo();
				var doclinksSet=mbo.getMboSet("DOCLINKS")
						if(doclinksSet.getMbo(0)!=null){
							var doclinks=doclinksSet.getMbo(0)
									val weurl = doclinks.getString("WEBURL")
									mbo.setValue("URL",weurl)
									if(mbo.isNull("DESCRIPTION")){
										mbo.setValue("DESCRIPTION",mbo.getString("UPDATEDLOG"))
									}
							fireStructureChangedEvent()
						}

			}
			MXApplicationYesNoCancelException.NO -> {

			}
			else -> {}
		}
		
		
	}
}