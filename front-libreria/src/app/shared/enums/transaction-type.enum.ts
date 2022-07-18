export enum TransactionTypeCode {
  Purchased = 1,
  Used = -1,
  ReturnedUnused = 2,
  Lost = -2,
  Found = 3,
  Sold = -3,
  TransferredIn = 4,
  TransferredOut = -4,
  DeliveredBack = 5,
  LentOut = -5,
  Trashed = 6
}

export enum TransactionType {
  Purchased = 'Purchased',
  Used = 'Used',
  ReturnedUnused = 'Returned Unused',
  Lost = 'Lost',
  Found = 'Found',
  Sold = 'Sold',
  TransferredIn = 'Transferred In',
  TransferredOut = 'Transferred Out',
  DeliveredBack = 'Deliver Back',
  LentOut = 'Lent Out',
  Trashed = 'Trashed'
}