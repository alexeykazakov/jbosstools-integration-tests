package org.jboss.tools.runtime.as.ui.bot.test.detector.server.eap70;

import org.jboss.reddeer.requirements.jre.JRERequirement.JRE;
import org.jboss.tools.runtime.as.ui.bot.test.template.OperateServerTemplate;

@JRE(cleanup=true)
public class OperateEAP70 extends OperateServerTemplate {

	@Override
	protected String getServerName() {
		return DetectEAP70.SERVER_NAME;
	}

}
