package PiViM.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class PiViModelingAssistantProviderOfIconsEditPart
		extends PiViM.diagram.providers.PiViModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(PiViM.diagram.providers.PiViElementTypes.CodeBlock_2001);
		return types;
	}

}
