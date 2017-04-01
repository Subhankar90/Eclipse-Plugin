package CodeBlockMM.diagram.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
public class CodeBlockCreationWizard extends Wizard implements INewWizard {

	/**
	* @generated
	*/
	private IWorkbench workbench;

	/**
	* @generated
	*/
	protected IStructuredSelection selection;

	/**
	* @generated
	*/
	protected CodeBlockMM.diagram.part.CodeBlockCreationWizardPage diagramModelFilePage;

	/**
	* @generated
	*/
	protected CodeBlockMM.diagram.part.CodeBlockCreationWizardPage domainModelFilePage;

	/**
	* @generated
	*/
	protected Resource diagram;

	/**
	* @generated
	*/
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	* @generated
	*/
	public IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	* @generated
	*/
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	* @generated
	*/
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	* @generated
	*/
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	* @generated
	*/
	public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	* @generated
	*/
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(CodeBlockMM.diagram.part.Messages.CodeBlockCreationWizardTitle);
		setDefaultPageImageDescriptor(CodeBlockMM.diagram.part.CodeBlockDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewCodeBlockMMWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	* @generated
	*/
	public void addPages() {
		diagramModelFilePage = new CodeBlockMM.diagram.part.CodeBlockCreationWizardPage("DiagramModelFile", //$NON-NLS-1$
				getSelection(), "codeblockmm_diagram"); //$NON-NLS-1$
		diagramModelFilePage
				.setTitle(CodeBlockMM.diagram.part.Messages.CodeBlockCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage.setDescription(
				CodeBlockMM.diagram.part.Messages.CodeBlockCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		domainModelFilePage = new CodeBlockMM.diagram.part.CodeBlockCreationWizardPage("DomainModelFile", //$NON-NLS-1$
				getSelection(), "codeblockmm") { //$NON-NLS-1$

			public void setVisible(boolean visible) {
				if (visible) {
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length() - ".codeblockmm_diagram".length()); //$NON-NLS-1$
					setFileName(CodeBlockMM.diagram.part.CodeBlockDiagramEditorUtil
							.getUniqueFileName(getContainerFullPath(), fileName, "codeblockmm")); //$NON-NLS-1$
				}
				super.setVisible(visible);
			}
		};
		domainModelFilePage
				.setTitle(CodeBlockMM.diagram.part.Messages.CodeBlockCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage.setDescription(
				CodeBlockMM.diagram.part.Messages.CodeBlockCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}

	/**
	* @generated
	*/
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				diagram = CodeBlockMM.diagram.part.CodeBlockDiagramEditorUtil
						.createDiagram(diagramModelFilePage.getURI(), domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						CodeBlockMM.diagram.part.CodeBlockDiagramEditorUtil.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(),
								CodeBlockMM.diagram.part.Messages.CodeBlockCreationWizardOpenEditorError, null,
								e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(),
						CodeBlockMM.diagram.part.Messages.CodeBlockCreationWizardCreationError, null,
						((CoreException) e.getTargetException()).getStatus());
			} else {
				CodeBlockMM.diagram.part.CodeBlockDiagramEditorPlugin.getInstance().logError("Error creating diagram", //$NON-NLS-1$
						e.getTargetException());
			}
			return false;
		}
		return diagram != null;
	}
}
