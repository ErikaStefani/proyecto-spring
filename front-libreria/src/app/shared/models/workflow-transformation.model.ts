export interface WorkflowTransformationDto {
  data: WorkflowTransformationDataDto[];
}

export interface WorkflowTransformationDataDto {
  isWfEnabled: number;
  transformations: WorkflowTranformationItemDto[];
}

export interface WorkflowTranformationItemDto {
  id: number;
  action: WorkflowTransformationAction;
  toStatus: WorkflowTransformationToStatus;
}

export interface WorkflowTransformationAction {
  id: number;
  descr: string;
}

export interface WorkflowTransformationToStatus {
  id: number;
  descr: string;
}