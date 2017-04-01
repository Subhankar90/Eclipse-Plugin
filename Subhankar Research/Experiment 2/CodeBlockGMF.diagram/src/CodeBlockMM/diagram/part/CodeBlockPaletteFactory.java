
package CodeBlockMM.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

/**
 * @generated
 */
public class CodeBlockPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createCodeBlockMM1Group());
	}

	/**
	* Creates "CodeBlockMM" palette tool group
	* @generated
	*/
	private PaletteContainer createCodeBlockMM1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(CodeBlockMM.diagram.part.Messages.CodeBlockMM1Group_title);
		paletteContainer.setId("createCodeBlockMM1Group"); //$NON-NLS-1$
		paletteContainer.add(createCodeBlock1CreationTool());
		paletteContainer.add(createConnection2CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createCodeBlock1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				CodeBlockMM.diagram.part.Messages.CodeBlock1CreationTool_title,
				CodeBlockMM.diagram.part.Messages.CodeBlock1CreationTool_desc,
				Collections.singletonList(CodeBlockMM.diagram.providers.CodeBlockElementTypes.CodeBlock_2001));
		entry.setId("createCodeBlock1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CodeBlockMM.diagram.providers.CodeBlockElementTypes
				.getImageDescriptor(CodeBlockMM.diagram.providers.CodeBlockElementTypes.CodeBlock_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createConnection2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				CodeBlockMM.diagram.part.Messages.Connection2CreationTool_title,
				CodeBlockMM.diagram.part.Messages.Connection2CreationTool_desc,
				Collections.singletonList(CodeBlockMM.diagram.providers.CodeBlockElementTypes.Connection_4001));
		entry.setId("createConnection2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CodeBlockMM.diagram.providers.CodeBlockElementTypes
				.getImageDescriptor(CodeBlockMM.diagram.providers.CodeBlockElementTypes.Connection_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
