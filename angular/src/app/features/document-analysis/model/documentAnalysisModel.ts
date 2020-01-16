export interface DocumentAnalysisModel
{
    staff?: BoundingBoxDA[]
}

export interface BoundingBoxDA
{
    x0: number,
    xf: number,
    y0: number,
    yf: number
}