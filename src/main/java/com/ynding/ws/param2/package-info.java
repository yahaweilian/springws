//@javax.xml.bind.annotation.XmlSchema(namespace = "http://www.chinatax.gov.cn/dataspec/", elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)

@XmlSchema(
		xmlns = {
//@XmlNs(namespaceURI = "http://www.chinatax.gov.cn/spec/", prefix = ""),
@XmlNs(namespaceURI = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi")
//,
//@XmlNs(namespaceURI = "http://www.w3.org/2001/XMLSchema", prefix = "xsd")
})

/*@XmlSchema( 
		//namespace = "http://www.chinatax.gov.cn/spec/", 
		//elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED,
		//elementFormDefault = javax.xml.bind.annotation.XmlNsForm.UNQUALIFIED,
		xmlns = { 
@XmlNs(namespaceURI = "http://www.chinatax.gov.cn/spec/", prefix = ""),
@XmlNs(namespaceURI = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi")
//,
//@XmlNs(namespaceURI = "http://www.w3.org/2001/XMLSchema", prefix = "xsd")
})*/

//@XmlSchema(
//	namespace="http://www.chinatax.gov.cn/spec/"
//	,
//	xmlns={
//			@XmlNs(prefix="xsd",namespaceURI="http://www.w3.org/2001/XMLSchema-instance")
//			,@XmlNs(prefix="",namespaceURI="http://www.chinatax.gov.cn/spec/")
//	}
//	,elementFormDefault=javax.xml.bind.annotation.XmlNsForm.QUALIFIED
////	,attributeFormDefault=javax.xml.bind.annotation.XmlNsForm.QUALIFIED
//) 


//@javax.xml.bind.annotation.XmlSchema(namespace="")
/***
 * @author zzy
 * 2016.06
 * 
 */
package com.ynding.ws.param2;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;

