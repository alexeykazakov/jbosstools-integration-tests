package org.jboss.ide.eclipse.as.ui.bot.test.eap4;

import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerReqType;
import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerRequirement.JBossServer;
import org.jboss.ide.eclipse.as.ui.bot.test.template.DeleteServerTemplate;
import org.jboss.reddeer.requirements.server.ServerReqState;

@JBossServer(state=ServerReqState.PRESENT, type=ServerReqType.EAP4_3)
public class DeleteServerEAP4Server extends DeleteServerTemplate {

}
